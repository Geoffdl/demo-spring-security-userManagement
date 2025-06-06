package fr.diginamic.demospringsecurityusermanagement.service;

import fr.diginamic.demospringsecurityusermanagement.entity.Article;
import fr.diginamic.demospringsecurityusermanagement.entity.UserApp;
import fr.diginamic.demospringsecurityusermanagement.exception.ProblemException;
import fr.diginamic.demospringsecurityusermanagement.repository.ArticleRepository;
import fr.diginamic.demospringsecurityusermanagement.repository.UserAppRepository;
import fr.diginamic.demospringsecurityusermanagement.validator.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service des opérations d'articles
 */
@Service
public class ArticleService
{
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserAppRepository userRepository;
    @Autowired
    private IValidator validator;
    
    /**
     * Ajoute un nouvel article en base
     * @param article     entité JPA
     * @param userDetails utilisateur connecté
     * @return entité managée
     * @throws ProblemException erreur de validation
     */
    @Transactional
    public Article createArticle(Article article, UserDetails userDetails) throws ProblemException
    {
        validator.isTrue((article.getTitre() != null && article.getContenu() != null),
                         "Le contenu ou le titre de l'article ne peuvent etre nuls");
        //        validator.isTrue((article.getTitre().length() > 2 && article.getContenu().length() > 2),
        //                         "Le titre et le contenu doivent etre d'au moins 2 caractères");
        
        UserApp user = userRepository.findByEmail(userDetails.getUsername())
                                     .orElseThrow(() -> new UsernameNotFoundException("Invalid user"));
        
        article.setAuteur(user);
        return articleRepository.save(article);
    }
}
