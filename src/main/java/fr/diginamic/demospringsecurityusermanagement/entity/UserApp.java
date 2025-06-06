package fr.diginamic.demospringsecurityusermanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Entité JPA utilisateur
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "user_app")
public class UserApp
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String email;
    private String password;
    
    @OneToMany(mappedBy = "auteur")
    
    private Set<Article> articles;
    
    public UserApp(String email, String password)
    {
        this.email = email;
        this.password = password;
    }
}
