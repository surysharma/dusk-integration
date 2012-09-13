package com.hedgebenefits.daos.impl;

import com.hedgebenefits.daos.AdminDao;
import com.hedgebenefits.domain.Admin;
import com.hedgebenefits.domain.Sector;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

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

    @Override
    public List<Admin> listAllAdmins() {
        List<Admin> adminList = sessionFactory.getCurrentSession().createCriteria(Admin.class)
                .setMaxResults(5)
                .list();
        return adminList;
    }

    public static void main(String... args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        SessionFactory sf = (SessionFactory) context.getBean("sessionFactory");
        AdminDaoImpl adminDao = new AdminDaoImpl(sf);
        adminDao.execute();
    }

    private void execute() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Admin admin = new Admin();
        admin.setUsername("someUser");
        admin.setPassword("somePassword");


        admin.setSectors(newArrayList(getSector("someSector1"), getSector("someSector2")));
        session.save(admin);

        session.getTransaction().commit();

        // delete operation
        session.beginTransaction();
        Admin loadedAdmin = (Admin) session.load(Admin.class, 1L);
        loadedAdmin.getSectors().remove(getSector("someSector1"));
        System.out.println(loadedAdmin.getUsername());
        session.getTransaction().commit();

    }

    private Sector getSector(String sectorName) {
        Sector sector = new Sector();
        sector.setName(sectorName);
        return sector;
    }
}
