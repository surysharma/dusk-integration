package com.hedgebenefits.domain;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name="sector")
public class Sector {
    private Long id;
    private String name;

    @Id
    @GeneratedValue
    @Column(name = "sector_id")
    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "sector_name")
    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sector() {}

    @Override
    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        return hashCodeBuilder.append(name).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        if (o== null || !(o instanceof Sector)){
            return false;
        }
        Sector sector = (Sector)o;
        return equalsBuilder.append(name, sector.getName()).isEquals();
    }
}
