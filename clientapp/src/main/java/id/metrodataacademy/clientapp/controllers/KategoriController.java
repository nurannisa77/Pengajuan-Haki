package id.metrodataacademy.clientapp.controllers;

import id.metrodataacademy.clientapp.models.Kategori;
import id.metrodataacademy.clientapp.services.KategoriService;
import id.metrodataacademy.clientapp.services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/kategori")

public class KategoriController {

  private KategoriService kategoriService;
  private FileService fileService;

  @GetMapping
  public String getAll(Model model) {
    model.addAttribute("kategori", kategoriService.getAll());
    model.addAttribute("isActive", "kategori");
    return "kategori/index";
  }

  @GetMapping("/create")
  public String createView(Kategori kategori, Model model) {
    model.addAttribute("Files", fileService.getAll());
    model.addAttribute("isActive", "kategori");
    return "kategori/create-view";
  }

  @PostMapping
  public String create(Kategori kategori) {
    kategoriService.create(kategori);
    return "redirect:/kategori";
  }

  @GetMapping("/{id}")
  public String getById(Model model, @PathVariable Integer id) {
    model.addAttribute("kategori", kategoriService.getById(id));
    model.addAttribute("isActive", "kategori");
    return "kategori/detail-kategori";
  }

  @GetMapping("/update/{id}")
  public String updateView(
    @PathVariable Integer id,
    Kategori kategori,
    Model model) 
    {
    model.addAttribute("kategori", kategoriService.getById(id));
    model.addAttribute("files", fileService.getAll());
    model.addAttribute("isActive", "kategori");
    return "kategori/update-view";
  }

  // @PutMapping("/{id}")
  // public String update(@PathVariable Integer id, Kategori kategori) {
  //   kategoriService.update(id, kategori);
  //   return "redirect:/kategori";
  // }

     @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    kategoriService.delete(id);
    return "redirect:/kategori";
  }
}