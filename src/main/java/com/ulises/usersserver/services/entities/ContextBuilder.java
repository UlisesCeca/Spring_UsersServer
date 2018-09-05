package com.ulises.usersserver.services.entities;

public final class ContextBuilder {
    private String name;

    public static ContextBuilder aContext() {
        return new ContextBuilder();
    }

    public ContextBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public Context build() {
        Context context = new Context();
        context.setName(this.name);
        return context;
    }
}
