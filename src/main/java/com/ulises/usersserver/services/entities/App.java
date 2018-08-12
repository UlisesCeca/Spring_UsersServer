package com.ulises.usersserver.services.entities;

import lombok.Data;

import java.util.Date;

@Data
public class App {
    private String name;
    private boolean banned;
    private Date suspendedUntil;
    private int suspendedTimes;
    private String role;
}
