package com.ulises.usersserver.services.repositories;

import com.ulises.usersserver.services.entities.Context;
import com.ulises.usersserver.services.entities.UserApp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAppRepository extends MongoRepository<UserApp, String> {
    boolean existsByUsernameAndContextAndEmail(String username, Context context, String email);
}
