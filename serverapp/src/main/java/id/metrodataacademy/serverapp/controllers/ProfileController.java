package id.metrodataacademy.serverapp.controllers;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import id.metrodataacademy.serverapp.models.Profile;
import id.metrodataacademy.serverapp.services.ProfileService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/profile")
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class ProfileController {
  private ProfileService profileService;

  @GetMapping
  public List<Profile> getAll() {
    return profileService.getAll();
  }

  @GetMapping("/{id}")
  public Profile getById(@PathVariable Integer id) {
    return profileService.getById(id);
  }

  @PutMapping("/{id}")
  public Profile update(@PathVariable Integer id, @RequestBody Profile profile) {
    return profileService.update(id, profile);
  }

  @DeleteMapping("/{id}")
  public Profile delete(@PathVariable Integer id) {
    return profileService.delete(id);
  }

  @GetMapping("/profile")
    public Profile getProfile(@RequestParam(name = "username") String username) {
        return profileService.getAccountByName(username);
    }
}