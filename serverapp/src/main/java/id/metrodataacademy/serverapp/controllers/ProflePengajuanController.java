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
import org.springframework.web.bind.annotation.RestController;
import id.metrodataacademy.serverapp.models.ProfilePengajuan;
import id.metrodataacademy.serverapp.services.ProfilePengajuanService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/profilePengajuan")
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class ProflePengajuanController {
  private ProfilePengajuanService profilePengajuanService;

  @GetMapping
  public List<ProfilePengajuan> getAll() {
    return profilePengajuanService.getAll();
  }

  @GetMapping("/{id}")
  public ProfilePengajuan getById(@PathVariable Integer id) {
    return profilePengajuanService.getById(id);
  }

  @PostMapping
  public ProfilePengajuan create(@RequestBody ProfilePengajuan profilePengajuan) {
    return profilePengajuanService.create(profilePengajuan);
  }

  @PutMapping("/{id}")
  public ProfilePengajuan update(@PathVariable Integer id, @RequestBody ProfilePengajuan profilePengajuan) {
    return profilePengajuanService.update(id, profilePengajuan);
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasAuthority('DELETE_USER')")
  public ProfilePengajuan delete(@PathVariable Integer id) {
    return profilePengajuanService.delete(id);
  }
}