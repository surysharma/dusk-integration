package com.hedgebenefits.daos;

import com.hedgebenefits.domain.Admin;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 01/07/2012
 * Time: 21:05
 * To change this template use File | Settings | File Templates.
 */
public interface AdminDao {

    void save(Admin admin);

    boolean isExistingUser(Admin admin);

    void updateExisting(Admin admin);
}
