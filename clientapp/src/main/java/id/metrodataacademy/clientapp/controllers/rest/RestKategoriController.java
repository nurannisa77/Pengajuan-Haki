package id.metrodataacademy.clientapp.controllers.rest;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.metrodataacademy.clientapp.models.Kategori;
import id.metrodataacademy.clientapp.services.KategoriService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/kategori")
public class RestKategoriController {
    private KategoriService kategoriService;

    @GetMapping
    public List<Kategori> getAll() {
        return kategoriService.getAll();
    }

    @PostMapping
  public Kategori create(@RequestBody Kategori kategori) {
    return kategoriService.create(kategori);
  }

  
    @GetMapping("/{id}")
    public Kategori getById(@PathVariable Integer id) {
        return kategoriService.getById(id);
    }

    @PutMapping("/{id}")
    public Kategori update(@PathVariable Integer id, @RequestBody Kategori kategori) {
      return kategoriService.update(id, kategori);
    }

    @DeleteMapping("/del/{id}")
    public Kategori delete(@PathVariable Integer id) {
      return kategoriService.delete(id);
    }

}
