package fr.diginamic.demospringsecurityusermanagement.controller;

import fr.diginamic.demospringsecurityusermanagement.entity.UserApp;
import fr.diginamic.demospringsecurityusermanagement.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user-app")
public class UserAppController
{
    @Autowired
    CustomUserDetailService customUserDetailService;
    
    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserApp userApp)
    {
        System.out.println("Register POST received: " + userApp.getEmail());
        customUserDetailService.createUser(
              userApp.getEmail(),
              userApp.getPassword());
        
        return "redirect:/view/login";
    }
}
