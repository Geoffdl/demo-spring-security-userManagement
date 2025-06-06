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
                    .requestMatchers("/h2-console/**", "/api/article/all", "api/user-app/register").permitAll()
                    .requestMatchers("/view/login", "/view/register", "/view/all").permitAll()
                    .anyRequest().authenticated())
              .formLogin(form -> form
                    .loginPage("/view/login")
                    .defaultSuccessUrl("/view/add-article", true)
                    .failureUrl("/view/login")
                    .permitAll())
              
              .logout(logout -> logout
                    .logoutSuccessUrl("/view/login")
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
