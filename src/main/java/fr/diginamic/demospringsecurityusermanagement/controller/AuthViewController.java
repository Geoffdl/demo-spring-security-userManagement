package fr.diginamic.demospringsecurityusermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/auth")
public class AuthViewController
{
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    
    @GetMapping("/register")
    public String createUserPage()
    {
        return "register";
    }
}
