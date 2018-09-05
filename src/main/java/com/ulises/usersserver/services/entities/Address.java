package com.ulises.usersserver.services.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
final class Address {
    private String country;
    private Integer zipCode;
    private String province;
    private String town;
    private String street;
    private Integer number;
    private Integer gate;
    private Integer stairs;
    private Integer floor;
    private Character door;
}
