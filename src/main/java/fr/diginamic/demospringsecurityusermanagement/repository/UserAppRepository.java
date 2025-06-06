package fr.diginamic.demospringsecurityusermanagement.repository;

import fr.diginamic.demospringsecurityusermanagement.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long>
{
}
