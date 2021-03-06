package com.ulises.usersserver.repositories;

import com.ulises.usersserver.services.entities.Context;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextsRepository extends JpaRepository<Context, String> {}