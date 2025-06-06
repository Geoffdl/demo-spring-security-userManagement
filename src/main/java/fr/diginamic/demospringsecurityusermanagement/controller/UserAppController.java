package fr.diginamic.demospringsecurityusermanagement.controller;

import fr.diginamic.demospringsecurityusermanagement.entity.UserApp;
import fr.diginamic.demospringsecurityusermanagement.exception.ProblemException;
import fr.diginamic.demospringsecurityusermanagement.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller pour les opérations utilisateurs
 */
@Controller
@RequestMapping("/auth")
public class UserAppController
{
    @Autowired
    CustomUserDetailService service;
    
    /**
     * Inscrit un nouvel utilisateur en base
     * @param userApp nouvel utilisateur via le formulaire de vue register.html
     * @return redirige vers la page de login
     */
    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserApp userApp) throws ProblemException
    {
        service.registerUser(userApp.getEmail(), userApp.getPassword());
        return "redirect:/view/login";
    }
}
