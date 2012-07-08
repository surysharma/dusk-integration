package com.hedgebenefits.domain;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 08/07/2012
 * Time: 00:53
 * To change this template use File | Settings | File Templates.
 */
public class Right {
//    ADMIN("administrator"),
//    COMPANY("Employer"),
//    EMPLOYEE("employee");
    private String right;

    public Right(String right) {
        this.right = right;
    }

    public String getName(){
        return right;
    }

}
