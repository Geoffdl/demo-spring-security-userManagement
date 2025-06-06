package fr.diginamic.demospringsecurityusermanagement.controller;

import fr.diginamic.demospringsecurityusermanagement.entity.Article;
import fr.diginamic.demospringsecurityusermanagement.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Vue articles controller
 */
@Controller
@RequestMapping("/view/article")
public class ArticleViewController
{
    
    @Autowired
    ArticleRepository repository;
    
    /**
     * Affiche la page d'ajout d'un article
     * @return affiche add-article.html
     */
    @GetMapping("/add")
    public String addArticle()
    {
        return "add-article";
    }
    
    /**
     * Affiche tous les articles
     * @param model mvc view article
     * @return affiche list-articles.html
     */
    @GetMapping("/all")
    public String findAll(Model model)
    {
        List<Article> articlesList = repository.findAll();
        model.addAttribute("articles", articlesList);
        return "list-articles";
    }
}
