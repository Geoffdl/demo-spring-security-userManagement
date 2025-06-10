package fr.diginamic.tp2;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static fr.diginamic.tp2.SHA256.findNonce;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SHA256Test
{
    String[] prenoms = {"Elisa", "Chloe", "Carole", "Aurelia", "Paul", "Pierre", "Geoffroy"};
    
    @Test
    void encodeClassmateNames() throws NoSuchAlgorithmException
    {
        for (String prenom : prenoms)
        {
            String hash = SHA256.getHash(prenom);
            System.out.println(prenom + " : " + SHA256.getHash(prenom));
            assertEquals(64, hash.length());
        }
        
        for (String prenom : prenoms)
        {
            int nonce = findNonce(prenom);
            System.out.println("Prénom: " + prenom + ", nonce: " + nonce);
            String hash = SHA256.getHash(prenom + nonce);
            System.out.print("\t | hash : " + hash + "\n");
            assertTrue(hash.startsWith("0000"));
        }
    }
}
