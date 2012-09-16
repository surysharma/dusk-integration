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
    private String password;

    

    private List<CompanySector> companySectors;


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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", orphanRemoval = true)
    public List<CompanySector> getCompanySectors() {
        return companySectors;
    }

    public void setCompanySectors(List<CompanySector> companySectors) {
        this.companySectors= companySectors;
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
        builder.append(companySectors, otherCompany.getCompanySectors());
        return builder.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder =
                new HashCodeBuilder()
                        .append(username)
                        .append(companySectors)
                        .append(password);
        return builder.hashCode();
    }

}
