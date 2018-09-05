package com.ulises.usersserver.repositories;

import com.ulises.usersserver.services.entities.Context;
import com.ulises.usersserver.services.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersAppRepository extends JpaRepository<UserApp, String> {
    boolean existsByContextAndEmail(Context context, String email);}
