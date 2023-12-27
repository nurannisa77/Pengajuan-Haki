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
import id.metrodataacademy.serverapp.models.File;
import id.metrodataacademy.serverapp.services.FileService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/file")
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class FileController {
  private FileService fileService;

  @GetMapping
  public List<File> getAll() {
    return fileService.getAll();
  }

  @GetMapping("/{id}")
  public File getById(@PathVariable Integer id) {
    return fileService.getById(id);
  }

  @PostMapping
  public File create(@RequestBody File file) {
    return fileService.create(file);
  }

  @PutMapping("/{id}")
  public File update(@PathVariable Integer id, @RequestBody File file) {
    return fileService.update(id, file);
  }

  @DeleteMapping("/{id}")
  public File delete(@PathVariable Integer id) {
    return fileService.delete(id);
  }
}