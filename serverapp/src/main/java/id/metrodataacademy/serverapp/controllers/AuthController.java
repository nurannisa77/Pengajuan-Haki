package id.metrodataacademy.serverapp.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import id.metrodataacademy.serverapp.models.Profile;
import id.metrodataacademy.serverapp.models.dto.request.LoginRequest;
import id.metrodataacademy.serverapp.models.dto.request.ProfileRequest;
import id.metrodataacademy.serverapp.models.dto.response.LoginResponse;
import id.metrodataacademy.serverapp.services.AuthService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping
public class AuthController {
    private AuthService authService;

    @PostMapping("/registration")
    public Profile registration(@RequestBody ProfileRequest profileRequest) {
        return authService.registration(profileRequest);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}