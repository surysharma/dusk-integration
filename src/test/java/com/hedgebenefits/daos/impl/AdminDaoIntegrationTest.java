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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private AdminDao adminDao;

    private Session session;

    @Before
    public void setUp() throws Exception {
        adminDao = new AdminDaoImpl(sessionFactory);
        session = sessionFactory.getCurrentSession();
    }

    @Test
    public void shouldSaveNewAdmin() {
        //given
        Admin admin = new Admin();
        admin.setUsername("someuser");
        admin.setPassword("somepassword");
        admin.setRight(new Right("admin"));

        assertNull(admin.getId());

        //and

        //when
        adminDao.save(admin);
        session.flush();

        //then
        List<Map<String,Object>> adminTableItems = jdbcTemplate.queryForList("select * from hb_admin");
        Map<String, Object> row = adminTableItems.get(0);
        assertNotNull(row.get("id"));
    }

    @Test
    public void shouldTellIfAdminWithUsernameAlreadyExists() {
        //given
        jdbcTemplate.update("insert into hb_admin (id, password, admin_right, username) values(?, ?, ?, ?)",
                1, "trsgt", "admin", "someuser");

        //and
        Admin admin = new Admin();
        admin.setId(1L);
        admin.setUsername("someuser");
        admin.setPassword("somepassword");
        admin.setRight(new Right("admin"));


        //when
        assertThat(adminDao.isExistingUser(admin), is(true));
    }

    @Test
    public void shouldUpdateAnExistingAdmin() {
        //given
        jdbcTemplate.update("insert into hb_admin (id, password, admin_right, username) values(?, ?, ?, ?)",
                1, "trsgt", "admin1", "someuser1");
        jdbcTemplate.update("insert into hb_admin (id, password, admin_right, username) values(?, ?, ?, ?)",
                2, "trsgt", "admin2", "someuser2");

        //and
        Admin admin = new Admin();
        admin.setId(2L);
        admin.setUsername("someuser2");
        admin.setPassword("somepassword2");
        //and the right is changed
        admin.setRight(new Right("company2"));

        //when
        adminDao.updateExisting(admin);
        session.flush();

        //then
        List<Map<String, Object>> adminTableItems = jdbcTemplate.queryForList("select * from hb_admin");
        String right = (String) adminTableItems.get(1).get("admin_right");
        assertThat(right, is("company2"));
    }

    @Test
    public void shouldListAllAdmins() {
        //given
        givenAnExistingAdminWith(1, "admin1", "pass1", "admin");
        givenAnExistingAdminWith(2, "admin2", "pass2", "admin");
        givenAnExistingAdminWith(3, "admin3", "pass3", "admin");

        //when
        Set<Admin> admins = adminDao.listAllAdmins();
        session.flush();

        //then
        assertThat(admins.size(), is(3));
    }

    @Test
    public void shouldListFirstFiveAdmins() {
        //given
        givenAnExistingAdminWith(1, "admin1", "pass1", "admin");
        givenAnExistingAdminWith(2, "admin2", "pass2", "admin");
        givenAnExistingAdminWith(3, "admin3", "pass3", "admin");
        givenAnExistingAdminWith(4, "admin4", "pass4", "admin");
        givenAnExistingAdminWith(5, "admin5", "pass5", "admin");
        givenAnExistingAdminWith(6, "admin6", "pass6", "admin");
        givenAnExistingAdminWith(7, "admin7", "pass7", "admin");

        //when
        Set<Admin> admins = adminDao.listAllAdmins();
        session.flush();

        //then
        assertThat(admins.size(), is(5));
    }



    private void givenAnExistingAdminWith(int id, String username, String password, String right) {
        jdbcTemplate.update("insert into hb_admin (id, password, admin_right, username) values (?,?,?,?)", id, username, password, right);
    }

}
