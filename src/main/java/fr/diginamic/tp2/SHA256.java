package fr.diginamic.tp2;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class SHA256
{
    public static String getHash(String input) throws NoSuchAlgorithmException
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        return (HexFormat.of().formatHex(hash));
    }
    
    public static int findNonce(String prenom) throws NoSuchAlgorithmException
    {
        int nonce = 1;
        while (true)
        {
            String neoPrenom = prenom + nonce;
            String hash = getHash(neoPrenom);
            if (hash.startsWith("0000"))
            {
                return nonce;
            }
            nonce++;
        }
    }
}
