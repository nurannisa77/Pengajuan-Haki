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
import id.metrodataacademy.serverapp.models.Pengajuan;
import id.metrodataacademy.serverapp.services.PengajuanService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/pengajuan")
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class PengajuanController {
  private PengajuanService pengajuanService;

  @GetMapping
  public List<Pengajuan> getAll() {
    return pengajuanService.getAll();
  }

  @GetMapping("/{id}")
  public Pengajuan getById(@PathVariable Integer id) {
    return pengajuanService.getById(id);
  }

  @PostMapping
  public Pengajuan create(@RequestBody Pengajuan pengajuan) {
    return pengajuanService.create(pengajuan);
  }

  @PutMapping("/{id}")
  public Pengajuan update(@PathVariable Integer id, @RequestBody Pengajuan pengajuan) {
    return pengajuanService.update(id, pengajuan);
  }

  @DeleteMapping("/del/{id}")
  public Pengajuan delete(@PathVariable Integer id) {
    return pengajuanService.delete(id);
  }
}