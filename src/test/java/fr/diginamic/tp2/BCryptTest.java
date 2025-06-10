package fr.diginamic.tp2;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BCryptTest
{
    String[] prenoms = {"Elisa", "Chloe", "Carole", "Aurelia", "Paul", "Pierre", "Geoffroy"};
    PasswordEncoder encoder = BCrypt.getInstance();
    
    @Test
    void encodeClassmateNames()
    {
        for (String prenom : prenoms)
        {
            System.out.println(prenom + " : " + encoder.encode(prenom));
            assertTrue(encoder.matches(prenom, encoder.encode(prenom)));
        }
        
        String totoHash = encoder.encode("toto");
        System.out.println(totoHash);
        String newTotoHash = encoder.encode("toto");
        System.out.println(newTotoHash);
        System.out.println(encoder.matches("toto", totoHash));
        System.out.println(encoder.matches("toto", newTotoHash));
    }
}
