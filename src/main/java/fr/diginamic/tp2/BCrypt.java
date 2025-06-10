package fr.diginamic.tp2;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCrypt
{
    public static PasswordEncoder getInstance()
    {
        return new BCryptPasswordEncoder();
    }
}
