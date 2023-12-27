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
import id.metrodataacademy.serverapp.models.StatusPengajuan;
import id.metrodataacademy.serverapp.services.StatusPengajuanService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/statusPengajuan")
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class StatusPengajuanController {
  private StatusPengajuanService statusPengajuanService;

  @GetMapping
  public List<StatusPengajuan> getAll() {
    return statusPengajuanService.getAll();
  }

  @GetMapping("/{id}")
  public StatusPengajuan getById(@PathVariable Integer id) {
    return statusPengajuanService.getById(id);
  }

  @PostMapping
  public StatusPengajuan create(@RequestBody StatusPengajuan statusPengajuan) {
    return statusPengajuanService.create(statusPengajuan);
  }

  @PutMapping("/{id}")
  @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
  public StatusPengajuan update(@PathVariable Integer id, @RequestBody StatusPengajuan statusPengajuan) {
    return statusPengajuanService.update(id, statusPengajuan);
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasAuthority('DELETE_USER')")
  public StatusPengajuan delete(@PathVariable Integer id) {
    return statusPengajuanService.delete(id);
  }
}