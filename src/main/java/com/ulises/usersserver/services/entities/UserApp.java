package com.ulises.usersserver.services.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users_app")
@Getter @Setter @EqualsAndHashCode(callSuper = true)
public final class UserApp extends UserWithEmail {}
