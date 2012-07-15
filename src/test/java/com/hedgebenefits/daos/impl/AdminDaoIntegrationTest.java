package com.hedgebenefits.daos.impl;

import com.hedgebenefits.daos.AdminDao;
import com.hedgebenefits.domain.Admin;
import com.hedgebenefits.domain.Right;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 14/07/2012
 * Time: 12:06
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-applicationContext.xml")
@Transactional
public class AdminDaoIntegrationTest {

    @Autowired
    private SessionFactory sessionFactory;

    private AdminDao adminDao;

    @Before
    public void setUp() throws Exception {
        adminDao = new AdminDaoImpl(sessionFactory);
    }

    @Test
    public void shouldSaveNewAdmin() {
        //given
        Session session = sessionFactory.getCurrentSession();
        Admin admin = new Admin();
        admin.setUsername("someuser");
        admin.setPassword("somepassword");
        admin.setRight(new Right("admin"));
        assertNull(admin.getId());

        //when
        adminDao.save(admin);
        session.flush();

        //then
        assertNotNull(admin.getId());
    }
}
