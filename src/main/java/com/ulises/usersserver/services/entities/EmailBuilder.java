package com.ulises.usersserver.services.entities;

import java.util.ArrayList;
import java.util.List;

public final class EmailBuilder {
    private String to;
    private String from;
    private String subject;
    private String body;
    private List<String> cc;
    private List<String> bcc;
    private Context context;

    private EmailBuilder() {
        this.cc = new ArrayList<>();
        this.bcc = new ArrayList<>();
    }

    public static EmailBuilder anEmail() {
        return new EmailBuilder();
    }

    public EmailBuilder withTo(String to) {
        this.to = to;
        return this;
    }

    public EmailBuilder withFrom(String from) {
        this.from = from;
        return this;
    }

    public EmailBuilder withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public EmailBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public EmailBuilder withCc(List<String> cc) {
        this.cc = cc;
        return this;
    }

    public EmailBuilder withBcc(List<String> bcc) {
        this.bcc = bcc;
        return this;
    }

    public EmailBuilder withContext(Context context) {
        this.context = context;
        return this;
    }

    public Email build() {
        Email email = new Email();
        email.setTo(this.to);
        email.setFrom(this.from);
        email.setSubject(this.subject);
        email.setBody(this.body);
        email.setCc(this.cc);
        email.setBcc(this.bcc);
        email.setContext(this.context);
        return email;
    }
}
