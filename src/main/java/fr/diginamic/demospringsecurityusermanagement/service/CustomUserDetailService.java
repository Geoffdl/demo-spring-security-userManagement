package fr.diginamic.demospringsecurityusermanagement.service;

import fr.diginamic.demospringsecurityusermanagement.entity.UserApp;
import fr.diginamic.demospringsecurityusermanagement.exception.ProblemException;
import fr.diginamic.demospringsecurityusermanagement.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service des opérations utilisateur
 */
@Service
public class CustomUserDetailService implements UserDetailsService
{
    @Autowired
    private UserAppRepository repository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    /**
     * Charge un utilisateur via son identifiant de connection (ici email)
     * @param email the username identifying the user whose data is required.
     * @return Une entité User avec les identifiants de connection de l'utilisateur
     * @throws UsernameNotFoundException utilisateur absent en base
     */
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
    
    /**
     * Inscrit un utilisateur
     * @param email    the username identifying the user whose data is required.
     * @param password the password
     * @return entité managée du nouvel utilisateur
     * @throws ProblemException l'utilisateur existe déjà
     */
    @Transactional
    public UserApp registerUser(String email, String password) throws ProblemException
    {
        if (repository.findByEmail(email).isPresent())
        {
            throw new ProblemException("User with email " + email + " already exists");
        }
        
        UserApp newUser = new UserApp(email, passwordEncoder.encode(password));
        return repository.save(newUser);
    }
}
