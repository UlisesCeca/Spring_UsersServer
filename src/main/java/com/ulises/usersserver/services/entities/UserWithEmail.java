package com.ulises.usersserver.services.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users_with_email")
@Inheritance(strategy= InheritanceType.JOINED)
@Getter @Setter @EqualsAndHashCode(callSuper = true)
public class UserWithEmail extends User {
    @Column(nullable = false)
    private String email;

    @Override
    public String toString() {
        return "UserWithEmail{" +
                "email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", context=" + context +
                ", creationDate=" + creationDate +
                ", app=" + app +
                '}';
    }
}