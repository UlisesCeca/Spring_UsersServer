package com.ulises.usersserver.services.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString @Getter @Setter
public final class Email {
    private String to;
    private String from;
    private String subject;
    private String body;
    private Context context;
    private List<String> cc;
    private List<String> bcc;

    Email() {
        this.cc = new ArrayList<>();
        this.bcc = new ArrayList<>();
    }
}
