package com.ulises.usersserver.services.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode @Getter @Setter
final class RoleCompositeKey implements Serializable {
    private String role;
    private String user;
}
