package com.ulises.usersserver.repositories;

import com.ulises.usersserver.services.entities.PasswordRecoveryToken;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PasswordRecoveryTokensRepository extends MongoRepository<PasswordRecoveryToken, String> {
    boolean existsByUsernameAndToken(String username, String token);
}