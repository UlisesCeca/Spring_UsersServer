package com.ulises.usersserver.services.entities;

public final class RoleBuilder {
    private String role;
    private User user;

    public static RoleBuilder aRole() {
        return new RoleBuilder();
    }

    public RoleBuilder withRole(String role) {
        this.role = role;
        return this;
    }

    public RoleBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public Role build() {
        Role role = new Role();
        role.setRole(this.role);
        role.setUser(this.user);
        return role;
    }
}
