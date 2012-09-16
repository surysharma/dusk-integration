package com.hedgebenefits.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="company")
//TODO: Add a table generation strategy
//@TableGenerator(name = "id_gen", table = "hb_index_table")
public class Company {

    private Long id;
    @NotBlank(message = "Username cannot not be null")
    private String username;
    @NotBlank(message = "Password cannot not be null")
    private String password;

    

    private List<Sector> sectors;


    //For Hibernate
    public Company() {}

    @Id
    @GeneratedValue
    @Column(name = "company_id")
    public Long getId() {
        return id;
    }


    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "company_fk")
    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors= sectors;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Company)) {
            return false;
        }
        Company otherCompany = (Company) o;
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(username, otherCompany.getUsername());
        builder.append(password, otherCompany.getPassword());
        builder.append(sectors, otherCompany.getSectors());
        return builder.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder =
                new HashCodeBuilder()
                        .append(username)
                        .append(sectors)
                        .append(password);
        return builder.hashCode();
    }

}
