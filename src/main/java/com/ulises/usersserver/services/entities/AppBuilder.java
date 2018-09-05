package com.ulises.usersserver.services.entities;

public final class AppBuilder {
    private String name;
    private String web;
    private String mailDomain;

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

    public App build() {
        App app = new App();
        app.setName(this.name);
        app.setWeb(this.web);
        app.setMailDomain(this.mailDomain);
        return app;
    }
}
