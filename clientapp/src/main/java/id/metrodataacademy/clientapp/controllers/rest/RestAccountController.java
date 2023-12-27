// package id.metrodataacademy.clientapp.controllers.rest;

// import org.springframework.security.core.Authentication;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import id.metrodataacademy.clientapp.models.Profile;
// import id.metrodataacademy.clientapp.services.ProfileService;
// import lombok.AllArgsConstructor;

// @RestController
// @AllArgsConstructor
// @RequestMapping("/profile")
// public class RestAccountController {

//     private ProfileService profileService;

//     @GetMapping 
//     public Profile getProfile(Authentication auth) {
//         return profileService.getProfile(auth.getName());
//     }

// }