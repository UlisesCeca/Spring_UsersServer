package com.ulises.usersserver.services.repositories;

import com.ulises.usersserver.services.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {}
