package fr.diginamic.demospringsecurityusermanagement.controller;

import fr.diginamic.demospringsecurityusermanagement.entity.Article;
import fr.diginamic.demospringsecurityusermanagement.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/view"})
public class PageController
{
    @Autowired
    ArticleRepository articleRepository;
    
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
    
    @GetMapping("/add-article")
    public String addArticle()
    {
        return "add-article";
    }
    
    @GetMapping("/all")
    public String findAll(Model model)
    {
        List<Article> articlesList = articleRepository.findAll();
        model.addAttribute("articles", articlesList);
        return "list-articles";
    }
}
