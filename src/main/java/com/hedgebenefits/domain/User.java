package com.hedgebenefits.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: sureshsharma
 * Date: 26/06/2013
 * Time: 20:38
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "tbl_user")
@SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq_gen")
    private Long id;
    private String username;
    private String bidName;

    public User(String username, String bidName) {
        this.username = username;
        this.bidName = bidName;
    }

    User(){}

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getBidName() {
        return bidName;
    }
}
