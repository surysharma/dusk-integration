package com.interop.dao;

import com.interop.domain.Admin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 06/02/2013
 * Time: 20:14
 * To change this template use File | Settings | File Templates.
 */
public class InteropRepository {
    public static AdminRepository getRepository() {
        Map<Long, Admin> data = new HashMap<Long, Admin>();
        data.put(1L, new Admin("admin1", "rights1"));
        data.put(2L, new Admin("admin2", "rights2"));
        data.put(3L, new Admin("admin3", "rights3"));
        data.put(4L, new Admin("admin4", "rights4"));
        return new AdminRepository(data);  //To change body of created methods use File | Settings | File Templates.
    }
}
