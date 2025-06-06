package fr.diginamic.demospringsecurityusermanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
          Exception
    {
        http
              .headers(headers -> headers        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
              .authorizeHttpRequests(auth -> auth
                                           .requestMatchers("/hello/public", "/login", "/hello/toto", "/h2-console/**").permitAll()
                                           .requestMatchers("/hello/private", "/hello/public-auth").authenticated()
                                           .anyRequest().authenticated()
                                    )
              .formLogin(form -> form
                               .loginPage("/login")
                               .defaultSuccessUrl("/hello/private", true)
                               .failureUrl("/hello/public")
                               .permitAll()
                        )
              .logout(logout -> logout
                            .logoutSuccessUrl("/login")
                            .permitAll()
                     )
              .csrf(AbstractHttpConfigurer::disable);
        
        return http.build();
    }
    
    @Bean
    public UserDetailsService userDetailsService()
    {
        UserDetails user = User.withUsername("Geoff").password(passwordEncoder().encode("toto")).build();
        UserDetails admin = User.withUsername("Bob").password(passwordEncoder().encode("toto")).build();
        
        return new InMemoryUserDetailsManager(user, admin);
    }
    
    @Bean
    public static PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
