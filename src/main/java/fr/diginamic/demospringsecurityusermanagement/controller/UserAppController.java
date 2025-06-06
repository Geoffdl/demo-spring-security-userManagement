package fr.diginamic.demospringsecurityusermanagement.controller;

import fr.diginamic.demospringsecurityusermanagement.entity.UserApp;
import fr.diginamic.demospringsecurityusermanagement.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-app")
public class UserAppController {
    @Autowired
    CustomUserDetailService customUserDetailService;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserApp userApp) {
        customUserDetailService.createUser(
                userApp.getEmail(),
                userApp.getPassword());

        return "Utilisateur crée";
    }
}
