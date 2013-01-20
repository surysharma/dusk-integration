package com.hedgebenefits.domain;

import javax.persistence.*;

/**
 * An address is an independent Entity
 */
@Entity
@Table(name = "address")
public class Address {

    @OneToOne(mappedBy = "shippingAddress", cascade = CascadeType.ALL)
    private User user;

    protected Address(String address, String postCode, String city){

        this.street = address;
        this.zipCode = postCode;
        this.city = city;
    }

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

    public static AddressBuilder addressBuilder(String address, String postCode, String city) {
        return new AddressBuilder(address, postCode, city);  //To change body of created methods use File | Settings | File Templates.
    }

    public static class AddressBuilder {
        private String address;
        private String postCode;
        private String city;

        public AddressBuilder(String address, String postCode, String city) {
            this.address = address;
            this.postCode = postCode;
            this.city = city;
        }

        public Address build() {
            return new Address(address, postCode, city);  //To change body of created methods use File | Settings | File Templates.
        }

        public AddressBuilder user(String someUser) {
            return this;  //To change body of created methods use File | Settings | File Templates.
        }
    }
}
