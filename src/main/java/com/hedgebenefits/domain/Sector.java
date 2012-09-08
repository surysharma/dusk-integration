package com.hedgebenefits.domain;


import javax.persistence.*;

@Entity
@Table(name="hb_sector")
public class Sector {
    private Long id;
    private String name;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "hb_sector")
    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
