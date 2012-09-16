package com.hedgebenefits.domain;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name="company_sector")
public class CompanySector {
    private Long id;

    private Sector sector;

    private Company company;

    @Id
    @GeneratedValue
    @Column(name = "company_sector_id")
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "sector_id")
    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @ManyToOne
    @JoinColumn(name = "company_fk")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompanySector() {}

    @Override
    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        return hashCodeBuilder
                .append(sector)
                .append(company)
                .hashCode();
    }

    @Override
    public boolean equals(Object o) {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        if (o== null || !(o instanceof CompanySector)){
            return false;
        }
        CompanySector companySector = (CompanySector)o;
        return equalsBuilder
                .append(sector, companySector.getSector())
                .append(company, companySector.getCompany())
            .isEquals();
    }
}
