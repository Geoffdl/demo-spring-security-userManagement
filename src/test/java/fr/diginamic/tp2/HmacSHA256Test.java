package fr.diginamic.tp2;

import org.junit.jupiter.api.Test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HmacSHA256Test
{
    String[] prenoms = {"Elisa", "Chloe", "Carole", "Aurelia", "Paul", "Pierre", "Geoffroy"};
    HmacSHA256 hmac = new HmacSHA256("mySecretKey");
    
    @Test
    void encodeClassmateNames() throws NoSuchAlgorithmException, InvalidKeyException
    {
        for (String prenom : prenoms)
        {
            System.out.println(prenom + ": " + hmac.encode(prenom));
        }
        String message = "Diginamic c'est chouette";
        String expected = "rFmL9AfdBKWnjSnRAxF/vLMvZXk1S+zUR21tjzVXrkA=";
        String result = "";
        for (int i = 0; i < Integer.MAX_VALUE; i++)
        {
            String key = String.valueOf(i);
            HmacSHA256 hmac2 = new HmacSHA256(key);
            result = hmac2.encode(message);
            if (result.equals(expected))
            {
                System.out.println("Clé trouvée : " + key);
                break;
            }
        }
        assertEquals(expected, result);
    }
}
