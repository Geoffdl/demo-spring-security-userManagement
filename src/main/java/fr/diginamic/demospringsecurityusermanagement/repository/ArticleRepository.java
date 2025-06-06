package fr.diginamic.demospringsecurityusermanagement.repository;

import fr.diginamic.demospringsecurityusermanagement.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Spring
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>
{
}
