package id.metrodataacademy.clientapp.controllers;

import id.metrodataacademy.clientapp.models.dto.request.LoginRequest;
import id.metrodataacademy.clientapp.models.dto.response.LoginResponse;
import id.metrodataacademy.clientapp.services.AuthService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
@RequestMapping("/login")
public class AuthController {

  private AuthService authService;

  @GetMapping
  public String loginView(LoginRequest loginRequest) {
    Authentication auth = SecurityContextHolder
        .getContext()
        .getAuthentication();

    if (auth instanceof AnonymousAuthenticationToken) {
      return "auth/login";
    }
    return "redirect:/home";
  }

  @PostMapping
  public String login(LoginRequest loginRequest, RedirectAttributes redirectAttributes, HttpSession session) {
    LoginResponse loginResponse = authService.login(loginRequest);
    if (loginResponse == null) {
      redirectAttributes.addFlashAttribute("alert", "Username atau Password salah");
      return "redirect:/login?error=true";
    }

    session.setAttribute("loginResponse", loginResponse);

    System.out.println("Response Name: " + loginResponse.getName());
    System.out.println("Response Email: " + loginResponse.getEmail());
    System.out.println("Response Hp: " + loginResponse.getPhone());
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    List<String> roles = authentication
        .getAuthorities()
        .stream()
        .map(authority -> authority.getAuthority())
        .collect(Collectors.toList());

    for (String role : roles) {
      if (role.equals("ROLE_USER")) {
        return "redirect:/home";
      }
      if (role.equals("ROLE_ADMIN")) {
        return "redirect:/home";
      }
    }

    return "redirect:/home";
  }
}