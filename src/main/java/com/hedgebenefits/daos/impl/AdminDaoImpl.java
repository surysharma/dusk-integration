package com.hedgebenefits.daos.impl;

import com.hedgebenefits.daos.AdminDao;
import com.hedgebenefits.domain.Admin;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 03/07/2012
 * Time: 07:15
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AdminDaoImpl implements AdminDao{

    private SessionFactory sessionFactory;

    @Autowired
    public AdminDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Admin admin) {
        sessionFactory.getCurrentSession().save(admin);
    }

    @Override
    public boolean isExistingUser(Admin admin) {
        return sessionFactory.getCurrentSession().get(Admin.class, admin.getId()) != null ? true: false;

    }

    @Override
    public void updateExisting(Admin admin) {
        sessionFactory.getCurrentSession().update(admin);
    }
}
