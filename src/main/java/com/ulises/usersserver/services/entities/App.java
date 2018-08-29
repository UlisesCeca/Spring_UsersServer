package com.ulises.usersserver.services.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "Apps")
public class App {
    @Id
    private String name;
    private String web;
    private String mailDomain;
    private Map<String, String> rrss;


    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getMailDomain() {
        return mailDomain;
    }

    public void setMailDomain(String mailDomain) {
        this.mailDomain = mailDomain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getRrss() {
        return rrss;
    }

    public void setRrss(Map<String, String> rrss) {
        this.rrss = rrss;
    }
}
