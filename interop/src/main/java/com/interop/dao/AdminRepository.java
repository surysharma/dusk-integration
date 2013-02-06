package com.interop.dao;

import com.interop.domain.Admin;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 06/02/2013
 * Time: 20:14
 * To change this template use File | Settings | File Templates.
 */
public class AdminRepository {
    private Map<Long, Admin> data;

    public AdminRepository(Map<Long, Admin> data) {
        this.data = data;
    }

    public Admin get(Long id) {
        return data.get(id);  //To change body of created methods use File | Settings | File Templates.
    }
}
