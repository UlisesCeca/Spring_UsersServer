package com.example.ulises.template.Services.Repositories;

import com.example.ulises.template.Services.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {}
