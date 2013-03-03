package com.hedgebenefits.domain.jpadomain;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: sureshsharma
 * Date: 01/03/2013
 * Time: 19:33
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Company extends AbstractEntity {

    @NotBlank(message = "Username cannot not be null")

    private String username;
    private String password;

    public Company(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getUsername(), getPassword());    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object o) {
        return Objects.equal(this, o);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("username", getUsername())
                .add("password", getPassword())
                .toString();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
