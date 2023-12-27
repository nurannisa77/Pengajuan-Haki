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
import id.metrodataacademy.serverapp.models.Status;
import id.metrodataacademy.serverapp.services.StatusService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/status")
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class StatusController {
  private StatusService statusService;

  @GetMapping
  public List<Status> getAll() {
    return statusService.getAll();
  }

  @GetMapping("/{id}")
  public Status getById(@PathVariable Integer id) {
    return statusService.getById(id);
  }

  @PostMapping
  @PreAuthorize("hasAuthority('CREATE_ADMIN')")
  public Status create(@RequestBody Status status) {
    return statusService.create(status);
  }

  @PutMapping("/{id}")
  @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
  public Status update(@PathVariable Integer id, @RequestBody Status status) {
    return statusService.update(id, status);
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasAuthority('DELETE_ADMIN')")
  public Status delete(@PathVariable Integer id) {
    return statusService.delete(id);
  }
}