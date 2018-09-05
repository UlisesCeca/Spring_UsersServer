package com.ulises.usersserver.services.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "apps")
@EqualsAndHashCode @Getter @Setter
public final class App {
    @Id
    @Column(length = 15)
    private String name;

    @Column(length = 40)
    private String web;

    @Column(length = 50)
    private String mailDomain;

    @OneToMany(mappedBy = "app", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SocialNetwork> socialNetworks;

    App() {
        this.socialNetworks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "App{" +
                "name='" + name + '\'' +
                ", web='" + web + '\'' +
                ", mailDomain='" + mailDomain + '\'' +
                ", socialNetworks=" + socialNetworks +
                '}';
    }
}
