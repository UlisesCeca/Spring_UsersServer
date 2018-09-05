package com.ulises.usersserver.repositories;

import com.ulises.usersserver.services.entities.Context;
import com.ulises.usersserver.services.entities.UserWithEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersWithEmailRepository extends JpaRepository<UserWithEmail, String> {
    Optional<UserWithEmail> findByUsernameAndContextAndEmail(String username, Context context, String email);
}
