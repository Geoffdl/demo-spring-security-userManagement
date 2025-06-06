package fr.diginamic.demospringsecurityusermanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    
    public UserApp(String email, Long id, String password)
    {
        this.email = email;
        this.id = id;
        this.password = password;
    }
}
