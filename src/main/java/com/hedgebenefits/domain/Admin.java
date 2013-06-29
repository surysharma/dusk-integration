package com.hedgebenefits.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="admin")
public class Admin {

    private Long id;
    private String username;
    private List<Receipt> receipts;
    private User user;

    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "user_name")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "user_password")    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Admin)) {
            return false;
        }
        Admin otherAdmin  = (Admin) o;
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(getUsername(), otherAdmin.getUsername());
        return builder.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getUsername());
        return builder.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("UserName:")
                .append(username)
                .toString();
    }
}
