package id.metrodataacademy.clientapp.controllers;

import id.metrodataacademy.clientapp.models.Pengajuan;
import id.metrodataacademy.clientapp.services.PengajuanService;
import id.metrodataacademy.clientapp.services.ProfileService;
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
@RequestMapping("/pengajuan")

public class PengajuanController {

  private PengajuanService pengajuanService;
  private ProfileService profileService;

  @GetMapping
  public String getAll(Model model) {
    model.addAttribute("pengajuan", pengajuanService.getAll());
    model.addAttribute("isActive", "pengajuan");
    return "pengajuan/index";
  }

  @GetMapping("/create")
  public String createView(Pengajuan pengajuan, Model model) {
    model.addAttribute("profile", profileService.getAll());
    model.addAttribute("isActive", "pengajuan");
    return "pengajuan/create-view";
  }

  @PostMapping
  public String create(Pengajuan pengajuan) {
    pengajuanService.create(pengajuan);
    return "redirect:/pengajuan";
  }

  @GetMapping("/{id}")
  public String getById(Model model, @PathVariable Integer id) {
    model.addAttribute("pengajuan", pengajuanService.getById(id));
    model.addAttribute("isActive", "pengajuan");
    return "pengajuan/detail-pengajuan";
  }

  @GetMapping("/update/{id}")
  public String updateView(
    @PathVariable Integer id,
    Pengajuan pengajuan,
    Model model) 
    {
    model.addAttribute("pengajuan", pengajuanService.getById(id));
    model.addAttribute("profile", profileService.getAll());
    model.addAttribute("isActive", "pengajuan");
    return "pengajuan/update-view";
  }

  @PutMapping("/{id}")
  public String update(@PathVariable Integer id, Pengajuan pengajuan) {
    pengajuanService.update(id, pengajuan);
    return "redirect:/pengajuan";
  }

     @DeleteMapping("/del/{id}")
  public String delete(@PathVariable Integer id) {
    pengajuanService.delete(id);
    return "redirect:/pengajuan";
  }

}