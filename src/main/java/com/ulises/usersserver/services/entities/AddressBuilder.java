package com.ulises.usersserver.services.entities;

public final class AddressBuilder {
    private String country;
    private String zipCode;
    private String province;
    private String town;
    private String street;
    private String number;
    private String gate;
    private String stairs;
    private String floor;
    private String door;

    private AddressBuilder() {
    }

    public static AddressBuilder anAddress() {
        return new AddressBuilder();
    }

    public AddressBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public AddressBuilder withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public AddressBuilder withProvince(String province) {
        this.province = province;
        return this;
    }

    public AddressBuilder withTown(String town) {
        this.town = town;
        return this;
    }

    public AddressBuilder withStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder withNumber(String number) {
        this.number = number;
        return this;
    }

    public AddressBuilder withGate(String gate) {
        this.gate = gate;
        return this;
    }

    public AddressBuilder withStairs(String stairs) {
        this.stairs = stairs;
        return this;
    }

    public AddressBuilder withFloor(String floor) {
        this.floor = floor;
        return this;
    }

    public AddressBuilder withDoor(String door) {
        this.door = door;
        return this;
    }

    public Address build() {
        Address address = new Address();
        address.setCountry(country);
        address.setZipCode(zipCode);
        address.setProvince(province);
        address.setTown(town);
        address.setStreet(street);
        address.setNumber(number);
        address.setGate(gate);
        address.setStairs(stairs);
        address.setFloor(floor);
        address.setDoor(door);
        return address;
    }
}
