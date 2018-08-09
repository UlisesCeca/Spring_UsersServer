package com.example.ulises.template.services.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
@Data
public class User {
    @Id
    private String username;
    private String surname;
    private String password;
}
