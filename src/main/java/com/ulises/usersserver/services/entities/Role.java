package com.ulises.usersserver.services.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users_roles")
@IdClass(RoleCompositeKey.class)
@Getter @Setter
public final class Role {
    @Id
    @Column(length = 20)
    private String role;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Override
    public String toString() {
        return "Role{" +
                "roles='" + role + '\'' +
                ", user=" + user.getId() +
                '}';
    }
}
