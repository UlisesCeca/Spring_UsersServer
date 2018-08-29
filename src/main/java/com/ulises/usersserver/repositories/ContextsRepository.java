package com.ulises.usersserver.repositories;

import com.ulises.usersserver.services.entities.Context;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContextsRepository extends MongoRepository<Context, String> {}