// package id.metrodataacademy.clientapp.controllers;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import id.metrodataacademy.clientapp.models.Kategori;
// import id.metrodataacademy.clientapp.services.ProfileService;
// import lombok.AllArgsConstructor;

// @Controller
// @AllArgsConstructor
// @RequestMapping("/profile")
// public class ProfileController {

// private ProfileService profileService;

// @GetMapping
// public String getAll(Model model) {
// model.addAttribute("profile", profileService.getAll());
// model.addAttribute("isActive", "profile");
// return "profileService/index";
// }

// @GetMapping("/{id}")
// public String getById(Model model, @PathVariable Integer id) {
// model.addAttribute("profileService", profileService.getById(id));
// model.addAttribute("isActive", "profile");
// return "profileService/detail-profileService";
// }

// @GetMapping("/update/{id}")
// public String updateView(
// @PathVariable Integer id,
// ProfileService profileService,
// Model model) {
// model.addAttribute("profileService", profileService.getById(id));
// model.addAttribute("profileService", profileService.getAll());
// model.addAttribute("isActive", "profile");
// return "profileService/update-view";
// }

// @PutMapping("/{id}")
// public String update(@PathVariable Integer id, Kategori kategori) {
// profileService.update(id, kategori);
// return "redirect:/profile";
// }

// @DeleteMapping("/{id}")
// public String delete(@PathVariable Integer id) {
// profileService.delete(id);
// return "redirect:/profileService";
// }
// }
