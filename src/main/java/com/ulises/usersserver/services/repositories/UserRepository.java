package com.ulises.usersserver.services.repositories;

import com.ulises.usersserver.services.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByEmailAndContext(String email, String context);
    boolean existsByUsernameAndContext(String username, String context);
    boolean existsByPhoneAndContext(String phone, String context);
    User findByUsername(String username);
}
