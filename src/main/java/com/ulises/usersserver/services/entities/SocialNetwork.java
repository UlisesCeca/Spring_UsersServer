package com.ulises.usersserver.services.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "social_networks")
@IdClass(SocialNetworkCompositeKey.class)
@Getter @Setter
public final class SocialNetwork {
    @Id
    @Column(length = 20)
    private String name;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private App app;

    @Column(nullable = false, length = 40)
    private String url;

    @Override
    public String toString() {
        return "SocialNetwork{" +
                "name='" + name + '\'' +
                ", app=" + app.getName() +
                ", url='" + url + '\'' +
                '}';
    }
}
