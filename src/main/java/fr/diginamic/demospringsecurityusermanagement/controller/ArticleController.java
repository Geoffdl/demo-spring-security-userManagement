package fr.diginamic.demospringsecurityusermanagement.controller;

import fr.diginamic.demospringsecurityusermanagement.entity.Article;
import fr.diginamic.demospringsecurityusermanagement.entity.UserApp;
import fr.diginamic.demospringsecurityusermanagement.repository.ArticleRepository;
import fr.diginamic.demospringsecurityusermanagement.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController
{
    @Autowired
    ArticleRepository repository;
    @Autowired
    UserAppRepository userRepository;
    
    @PostMapping("/new")
    public String registerArticle(@ModelAttribute Article article, Authentication authentication)
    {
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        UserApp user = userRepository.findByEmail(username)
                                     .orElseThrow(() -> new UsernameNotFoundException("Invalid user"));
        
        article.setAuteur(user);
        repository.save(article);
        
        return "article créé";
    }
    
    @GetMapping("/all")
    public String findAll()
    {
        List<Article> articles = repository.findAll();
        StringBuilder sb = new StringBuilder();
        
        for (Article a : articles)
        {
            sb.append("Article : ").append(a.getTitre()).append("\n\t").append(a.getAuteur().getEmail()).append("\n");
        }
        return sb.toString();
    }
}
