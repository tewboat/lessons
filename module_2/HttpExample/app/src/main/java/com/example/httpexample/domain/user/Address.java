package com.example.httpexample.domain.user;

public class Address {
    public final String street;
    public final String suite;
    public final String city;
    public final String zipcode;
    public final Geo geo;

    public Address(String street, String suite, String city, String zipcode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }
}
