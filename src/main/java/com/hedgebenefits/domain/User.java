package com.hedgebenefits.domain;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    protected User(){}

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }


    public User getInstance(){
        return UserBuilder.UserBuilder().build();
    }
    


    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private Address address;

        public static UserBuilder UserBuilder() {
            return new UserBuilder();  //To change body of created methods use File | Settings | File Templates.
        }

        public User build() {
            User user = new User();
            user.firstName = firstName;
            user.lastName = lastName;
            user.shippingAddress = address;
            return user;  //To change body of created methods use File | Settings | File Templates.
        }

        public UserBuilder firstName(String body) {
            firstName = body;
            return this;  //To change body of created methods use File | Settings | File Templates.
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;  //To change body of created methods use File | Settings | File Templates.
        }

        public UserBuilder address(Address address) {
            this.address = address;
            return this;  //To change body of created methods use File | Settings | File Templates.
        }
    }
}
