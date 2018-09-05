package com.ulises.usersserver.repositories;

import com.ulises.usersserver.services.entities.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppsRepository extends JpaRepository<App, String> {
}
