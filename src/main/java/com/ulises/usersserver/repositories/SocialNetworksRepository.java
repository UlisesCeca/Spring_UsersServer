package com.ulises.usersserver.repositories;

import com.ulises.usersserver.services.entities.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialNetworksRepository extends JpaRepository<SocialNetwork, String> {}