package fr.diginamic.demospringsecurityusermanagement.service;

import fr.diginamic.demospringsecurityusermanagement.entity.UserApp;
import fr.diginamic.demospringsecurityusermanagement.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService
{
    @Autowired
    UserAppRepository repository;
    @Autowired
    private PasswordEncoder bcrypt;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        UserApp user = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        return User.builder()
                   .username(user.getEmail())
                   .password(user.getPassword())
                   .roles("USER")
                   .build();
    }
    
    public void createUser(String username, String password)
    {
        repository.save(new UserApp(username, bcrypt.encode(password)));
    }
}
