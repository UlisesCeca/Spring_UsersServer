package com.ulises.usersserver.services.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contexts")
@ToString @EqualsAndHashCode @Getter @Setter
public final class Context {
    @Id
    @Column(length = 15)
    private String name;
}
