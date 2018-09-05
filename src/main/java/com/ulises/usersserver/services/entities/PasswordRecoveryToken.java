package com.ulises.usersserver.services.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "password_recovery_tokens")
@ToString @EqualsAndHashCode @Getter @Setter
public final class PasswordRecoveryToken implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private UserWithEmail user;

    @Column(nullable = false)
    private Date expiration;

    @Column(nullable = false)
    private Integer token;
}
