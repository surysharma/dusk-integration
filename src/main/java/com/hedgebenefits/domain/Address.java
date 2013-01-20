package com.hedgebenefits.domain;

import javax.persistence.*;

/**
 * An address is an independent Entity
 */
@Entity
@Table(name = "address")
public class Address {
    private static Address address = new Address();

    @OneToOne(mappedBy = "shippingAddress", cascade = CascadeType.ALL)
    private User user;

    protected Address(){}

    @Id
    @GeneratedValue
    private Long id;
    @Column(name="street")
    private String street;
    @Column(name="zipcode")
    private String zipCode;
    @Column(name = "city")
    private String city;



    public String getStreet(){
        return street;
    }

    public static Address getInstance(String street, String zipCode, String city) {
        address.street = street;
        address.zipCode = zipCode;
        address.city = city;
        return address;
    }

    public static Address getAddress() {
        return address;
    }

    public Long getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
