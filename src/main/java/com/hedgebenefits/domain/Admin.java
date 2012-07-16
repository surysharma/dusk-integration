package com.hedgebenefits.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name="hb_admin")
//TODO: Add a table generation strategy
//@TableGenerator(name = "id_gen", table = "hb_index_table")
public class Admin {

    private Long id;
    @NotBlank(message = "Username cannot not be null")
    private String username;
    @NotBlank(message = "Password cannot not be null")
    private String password;

    private Right right;

    public Admin(String username, String password, Right right) {
        this.username = username;
        this.password = password;
        this.right = right;
    }

    //For Hibernate
    public Admin() {}

    @Id
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_gen")
    public Long getId() {
        return id;
    }

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "right", column = @Column(name = "admin_right")))
    public Right getRight() {
        return right;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setRight(Right right) {
        this.right = right;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Admin)) {
            return false;
        }
        Admin otherAdmin  = (Admin) o;
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(getUsername(), otherAdmin.getUsername());
        builder.append(getPassword(), otherAdmin.getPassword());
        builder.append(getRight(), otherAdmin.getRight());
        return builder.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getUsername());
        builder.append(getPassword());
        builder.append(getRight());
        return builder.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("UserName:")
                .append(username)
                .append("Right:")
                .append(right)
                .toString();
    }
}
