package fr.diginamic.demospringsecurityusermanagement.controller;

import fr.diginamic.demospringsecurityusermanagement.entity.Article;
import fr.diginamic.demospringsecurityusermanagement.exception.ProblemException;
import fr.diginamic.demospringsecurityusermanagement.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller des opérations d'articles
 */
@Controller
@RequestMapping("/article")
public class ArticleController
{
    
    @Autowired
    private ArticleService articleService;
    
    /**
     * Ajoute un nouvel article
     * @param article        article reçu via le formulaire de la page add-article.html
     * @param authentication cookie d'authentification de l'utilisateur connecté
     * @return redirige vers la page d'ajout d'article
     */
    @PostMapping("/new")
    public String registerArticle(@ModelAttribute Article article, Authentication authentication) throws
          ProblemException
    {
        Article savedArticle = articleService.createArticle(article, (UserDetails) authentication.getPrincipal());
        System.out.println("Article POST received: " + savedArticle.getTitre());
        return "redirect:/view/article/add";
    }
}
