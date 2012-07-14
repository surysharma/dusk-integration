package com.hedgebenefits.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 08/07/2012
 * Time: 00:53
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class Right implements Serializable {
//    ADMIN("administrator"),
//    COMPANY("Employer"),
//    EMPLOYEE("employee");
    private String right;

    public Right(String right) {
        this.right = right;
    }

    protected Right(){}

    public String getRight(){
        return right;
    }


    public void setRight(String right) {
        this.right = right;
    }
}
