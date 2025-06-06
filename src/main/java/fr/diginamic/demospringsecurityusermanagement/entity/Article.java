package fr.diginamic.demospringsecurityusermanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "article")
public class Article
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String titre;
    private String contenu;
    
    @ManyToOne
    @JoinColumn(name = "id_auteur", referencedColumnName = "id")
    private UserApp auteur;
    
    public Article(String titre, String contenu)
    {
        this.titre = titre;
        this.contenu = contenu;
    }
}
