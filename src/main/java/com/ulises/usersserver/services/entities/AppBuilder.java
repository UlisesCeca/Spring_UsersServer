package com.ulises.usersserver.services.entities;

import java.util.HashMap;
import java.util.Map;

public final class AppBuilder {
    private String name;
    private String web;
    private String mailDomain;
    private Map<String, String> rrss;

    private AppBuilder() {
        this.rrss = new HashMap<>();
    }

    public static AppBuilder anApp() {
        return new AppBuilder();
    }

    public AppBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AppBuilder withWeb(String web) {
        this.web = web;
        return this;
    }

    public AppBuilder withMailDomain(String mailDomain) {
        this.mailDomain = mailDomain;
        return this;
    }

    public AppBuilder withRrss(Map<String, String> rrss) {
        this.rrss = rrss;
        return this;
    }

    public App build() {
        App app = new App();
        app.setName(name);
        app.setWeb(web);
        app.setMailDomain(mailDomain);
        app.setRrss(rrss);
        return app;
    }
}
