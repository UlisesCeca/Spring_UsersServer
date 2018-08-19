package com.ulises.usersserver.services.entities;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private String to;
    private String from;
    private String subject;
    private String body;
    private List<String> cc;
    private List<String> bcc;
    private Context context;


    public Email() {
        this.cc = new ArrayList<>();
        this.bcc = new ArrayList<>();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }
}
