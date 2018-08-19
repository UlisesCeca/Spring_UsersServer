package com.ulises.usersserver.services.entities;

import java.util.ArrayList;
import java.util.List;

public class EmailBuilder {
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

    public static EmailBuilder builder() { return new EmailBuilder(); }

    public EmailBuilder to(final String to) {
        this.to = to;
        return this;
    }

    public EmailBuilder from(final String from) {
        this.from = from;
        return this;
    }

    public EmailBuilder subject(final String subject) {
        this.subject = subject;
        return this;
    }

    public EmailBuilder body(final String body) {
        this.body = body;
        return this;
    }

    public EmailBuilder cc(final List<String> cc) {
        this.cc = cc;
        return this;
    }

    public EmailBuilder bcc(final List<String> bcc) {
        this.bcc = bcc;
        return this;
    }

    public EmailBuilder context(final Context context) {
        this.context = context;
        return this;
    }

    public Email build() {
        Email entity = new Email();
        entity.setTo(this.to);
        entity.setBody(this.body);
        entity.setSubject(this.subject);
        entity.setFrom(this.from);
        entity.setContext(this.context);
        entity.setCc(this.cc);
        entity.setBcc(this.bcc);
        return entity;
    }
}
