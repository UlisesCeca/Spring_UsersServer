package com.ulises.usersserver.services.entities;

import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy= InheritanceType.JOINED)
@EqualsAndHashCode @Getter @Setter
public class User {
    @Id
    protected String id;

    @Column(nullable = false)
    protected String username;

    @Column(nullable = false)
    protected String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    protected List<Role> roles;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "context", nullable = false)
    protected Context context;

    @Column(nullable = false)
    protected Date creationDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app", nullable = false)
    protected App app;

    User() {
        this.roles = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", context=" + context +
                ", creationDate=" + creationDate +
                ", app=" + app +
                '}';
    }

    /*private String dni;
    private String name;
    private String surname;
    private int age;
    private Date birth;
    private Address address;
    private String phone;
    private String email;*/

}
