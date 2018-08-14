package com.ulises.usersserver.services.entities;

public class ContextBuilder {
    private String name;

    public static ContextBuilder builder() { return new ContextBuilder(); }

    public ContextBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public Context build() {
        Context entity = new Context();
        entity.setName(this.name);
        return entity;
    }
}
