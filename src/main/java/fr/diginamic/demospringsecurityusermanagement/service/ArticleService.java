package fr.diginamic.demospringsecurityusermanagement.service;

import fr.diginamic.demospringsecurityusermanagement.entity.Article;
import fr.diginamic.demospringsecurityusermanagement.entity.UserApp;
import fr.diginamic.demospringsecurityusermanagement.repository.ArticleRepository;
import fr.diginamic.demospringsecurityusermanagement.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserAppRepository userRepository;

    @Transactional
    public Article createArticle(Article article, UserDetails userDetails) {
        UserApp user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Invalid user"));

        article.setAuteur(user);
        return articleRepository.save(article);
    }
}
