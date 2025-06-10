package fr.diginamic.tp2;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HmacSHA256
{
    private final String secretKey;
    private final String algorithm = "HmacSHA256";
    
    public HmacSHA256(String secretKey)
    {
        this.secretKey = secretKey;
    }
    
    private SecretKeySpec setSpec()
    {
        return new SecretKeySpec(secretKey.getBytes(), algorithm);
    }
    
    private Mac setMac() throws NoSuchAlgorithmException, InvalidKeyException
    {
        Mac mac = Mac.getInstance(algorithm);
        mac.init(setSpec());
        return mac;
    }
    
    private byte[] calculateHMAC(String message) throws NoSuchAlgorithmException, InvalidKeyException
    {
        return setMac().doFinal(message.getBytes());
    }
    
    public String encode(String target) throws NoSuchAlgorithmException, InvalidKeyException
    {
        return Base64.getEncoder().encodeToString(calculateHMAC(target));
    }
}
