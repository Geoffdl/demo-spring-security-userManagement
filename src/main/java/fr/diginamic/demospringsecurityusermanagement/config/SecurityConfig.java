package fr.diginamic.demospringsecurityusermanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http
              .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
              .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/h2-console/**", "auth/register", "/view/auth/register", "/view/auth/login")
                    .permitAll()
                    .requestMatchers("/article/new", "/view/article/all").permitAll()
                    .anyRequest().authenticated())
              .formLogin(form -> form
                    .loginPage("/view/auth/login")
                    .defaultSuccessUrl("/view/article/add", true)
                    .failureUrl("/view/auth/login")
                    .permitAll())
              
              .logout(logout -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/view/auth/login")
                    .permitAll())
              .csrf(AbstractHttpConfigurer::disable);
        
        return http.build();
    }
    
    @Bean
    public static PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
