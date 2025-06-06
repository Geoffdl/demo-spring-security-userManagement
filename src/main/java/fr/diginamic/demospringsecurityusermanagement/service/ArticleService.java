package fr.diginamic.demospringsecurityusermanagement.service;

import fr.diginamic.demospringsecurityusermanagement.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService
{
    @Autowired
    ArticleRepository repository;
}
