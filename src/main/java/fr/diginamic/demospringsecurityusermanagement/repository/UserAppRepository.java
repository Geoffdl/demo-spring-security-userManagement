package fr.diginamic.demospringsecurityusermanagement.repository;

import fr.diginamic.demospringsecurityusermanagement.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long>
{
    
    Optional<UserApp> findByEmail(String email);
}
