package com.ulises.usersserver.repositories;

import com.ulises.usersserver.services.entities.PasswordRecoveryToken;
import com.ulises.usersserver.services.entities.UserWithEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordRecoveryTokensRepository extends JpaRepository<PasswordRecoveryToken, Long> {
    Optional<PasswordRecoveryToken> findByUser(UserWithEmail user);
    Optional<PasswordRecoveryToken> findByTokenAndUser(Integer token, UserWithEmail user);
}