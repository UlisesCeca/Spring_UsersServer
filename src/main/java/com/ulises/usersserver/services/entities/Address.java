package com.ulises.usersserver.services.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String country;
    private String zipCode;
    private String province;
    private String town;
    private String street;
    private String number;
    private String gate;
    private String stairs;
    private String floor;
    private String door;
}
