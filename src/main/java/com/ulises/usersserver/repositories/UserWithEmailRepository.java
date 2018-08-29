package com.ulises.usersserver.repositories;

import com.ulises.usersserver.services.entities.Context;
import com.ulises.usersserver.services.entities.UserWithEmail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWithEmailRepository extends MongoRepository<UserWithEmail, String> {
    boolean existsByUsernameAndContextAndEmail(String username, Context context, String email);
    boolean existsByContextAndEmail(Context context, String email);
}
