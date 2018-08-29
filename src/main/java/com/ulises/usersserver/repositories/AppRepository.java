package com.ulises.usersserver.repositories;

import com.ulises.usersserver.services.entities.App;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppRepository extends MongoRepository<App, String> {}
