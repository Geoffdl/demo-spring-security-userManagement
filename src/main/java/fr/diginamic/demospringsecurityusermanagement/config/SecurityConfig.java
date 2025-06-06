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
                    .requestMatchers("/h2-console/**", "/article/all", "/login", "/register", "/user-app/register")
                    .permitAll()
                    //                    .requestMatchers("/hello/private", "/hello/public-auth").authenticated()
                    .anyRequest().authenticated())
              .formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/article/all", true)
                    .failureUrl("/login")
                    .permitAll())
              
              .logout(logout -> logout
                    .logoutSuccessUrl("/login")
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
