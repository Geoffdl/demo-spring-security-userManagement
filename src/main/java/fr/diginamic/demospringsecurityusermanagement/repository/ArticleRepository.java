package fr.diginamic.demospringsecurityusermanagement.repository;

import fr.diginamic.demospringsecurityusermanagement.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long>
{
}
