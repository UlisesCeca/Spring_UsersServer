package com.ulises.usersserver.services.repositories;

import com.ulises.usersserver.services.entities.Context;
import com.ulises.usersserver.services.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByEmailAndContext(String email, Context context);
    boolean existsByUsernameAndContext(String username, Context context);
    boolean existsByPhoneAndContext(String phone, Context context);
    boolean existsByIdAndContext(String id, Context context);
    User findByUsername(String username);
}
