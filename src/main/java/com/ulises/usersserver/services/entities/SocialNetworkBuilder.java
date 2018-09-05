package com.ulises.usersserver.services.entities;

public final class SocialNetworkBuilder {
    private String name;
    private App app;
    private String url;

    public static SocialNetworkBuilder aSocialNetwork() {
        return new SocialNetworkBuilder();
    }

    public SocialNetworkBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public SocialNetworkBuilder withApp(App app) {
        this.app = app;
        return this;
    }

    public SocialNetworkBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public SocialNetwork build() {
        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.setName(this.name);
        socialNetwork.setApp(this.app);
        socialNetwork.setUrl(this.url);
        return socialNetwork;
    }
}
