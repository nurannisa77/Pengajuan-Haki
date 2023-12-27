package id.metrodataacademy.serverapp.controllers;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import id.metrodataacademy.serverapp.models.Role;
import id.metrodataacademy.serverapp.models.User;
import id.metrodataacademy.serverapp.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class UserController {
  private UserService userService;

  @GetMapping
  public List<User> getAll() {
    return userService.getAll();
  }

  @GetMapping("/{id}")
  public User getById(@PathVariable Integer id) {
    return userService.getById(id);
  }

  @PutMapping("/{id}")
  public User update(@PathVariable Integer id, @RequestBody User user) {
    return userService.update(id, user);
  }

  @PutMapping("addrole/{id}")
  public User addRole(@PathVariable Integer id, @RequestBody Role role) {
    return userService.addRole(id, role);
  }

  @DeleteMapping("/{id}")
  public User delete(@PathVariable Integer id) {
    return userService.delete(id);
  }
}