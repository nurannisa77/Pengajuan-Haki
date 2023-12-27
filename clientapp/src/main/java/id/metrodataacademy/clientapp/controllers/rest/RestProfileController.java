package id.metrodataacademy.clientapp.controllers.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import id.metrodataacademy.clientapp.models.Profile;
import id.metrodataacademy.clientapp.services.ProfileService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/profile")
public class RestProfileController {
    private ProfileService profileService;

     @GetMapping("/profile") 
    public Profile getProfile(Authentication auth) {
        String username = auth.getName();
        return profileService.All(username);
    }

    @GetMapping
    public List<Profile> getAll() {
        return profileService.getAll();
    }

    @PutMapping("/update/{id}")
    public Profile update(@PathVariable Integer id, @RequestBody Profile profile) {
        return profileService.update(id, profile);
    }


    @GetMapping("/{id}")
    public Profile getById(@PathVariable Integer id) {
        return profileService.getById(id);
    }

 

}
