package fr.diginamic.demospringsecurityusermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Vue authentification
 */
@Controller
@RequestMapping("/view/auth")
public class AuthViewController
{
    /**
     * Affiche la page de login
     * @return login.html
     */
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    
    /**
     * Affiche la page d'inscription
     * @return register.html
     */
    @GetMapping("/register")
    public String createUserPage()
    {
        return "register";
    }
}
