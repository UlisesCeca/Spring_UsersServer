package com.ulises.usersserver.services.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode @Getter @Setter
final class SocialNetworkCompositeKey implements Serializable {
    private String name;
    private String app;
}
