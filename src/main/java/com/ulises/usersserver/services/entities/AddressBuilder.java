package com.ulises.usersserver.services.entities;

public final class AddressBuilder {
    private String country;
    private Integer zipCode;
    private String province;
    private String town;
    private String street;
    private Integer number;
    private Integer gate;
    private Integer stairs;
    private Integer floor;
    private Character door;

    public static AddressBuilder anAddress() {
        return new AddressBuilder();
    }

    public AddressBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public AddressBuilder withZipCode(Integer zipCode) {
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

    public AddressBuilder withNumber(Integer number) {
        this.number = number;
        return this;
    }

    public AddressBuilder withGate(Integer gate) {
        this.gate = gate;
        return this;
    }

    public AddressBuilder withStairs(Integer stairs) {
        this.stairs = stairs;
        return this;
    }

    public AddressBuilder withFloor(Integer floor) {
        this.floor = floor;
        return this;
    }

    public AddressBuilder withDoor(Character door) {
        this.door = door;
        return this;
    }

    public Address build() {
        Address address = new Address();
        address.setCountry(this.country);
        address.setZipCode(this.zipCode);
        address.setProvince(this.province);
        address.setTown(this.town);
        address.setStreet(this.street);
        address.setNumber(this.number);
        address.setGate(this.gate);
        address.setStairs(this.stairs);
        address.setFloor(this.floor);
        address.setDoor(this.door);
        return address;
    }
}
