package id.metrodataacademy.clientapp.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import id.metrodataacademy.clientapp.models.dto.response.LoginResponse;


@Controller
public class HomeController {

    @GetMapping

    public String home(Model model, Authentication auth, HttpSession session) {
        if (auth != null) {
            model.addAttribute("name", auth.getName());
        }
        model.addAttribute("isActive", "home");
        LoginResponse loginResponse = (LoginResponse) session.getAttribute("loginResponse");
        model.addAttribute("id", loginResponse.getId());
        model.addAttribute("nama", loginResponse.getName());
        model.addAttribute("email", loginResponse.getEmail());
        model.addAttribute("phone", loginResponse.getPhone());
        model.addAttribute("alamat", loginResponse.getAlamat());
        return "index";
    }

    @GetMapping("/home")
    public String dashboard(Model model, Authentication auth, HttpSession session) {
        LoginResponse loginResponse = (LoginResponse) session.getAttribute("loginResponse");
        model.addAttribute("id", loginResponse.getId());
        model.addAttribute("nama", loginResponse.getName());
        model.addAttribute("email", loginResponse.getEmail());
        model.addAttribute("phone", loginResponse.getPhone());
        model.addAttribute("alamat", loginResponse.getAlamat());
        model.addAttribute("isActive","home");
        model.addAttribute("login", auth.getName());
        return "index";
    }



    }