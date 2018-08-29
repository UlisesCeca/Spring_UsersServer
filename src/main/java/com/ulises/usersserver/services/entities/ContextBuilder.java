package com.ulises.usersserver.services.entities;

public final class ContextBuilder {
    private String name;

    private ContextBuilder() {
    }

    public static ContextBuilder aContext() {
        return new ContextBuilder();
    }

    public ContextBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public Context build() {
        Context context = new Context();
        context.setName(name);
        return context;
    }
}
