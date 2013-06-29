package com;

import com.hedgebenefits.domain.Admin;
import com.hedgebenefits.domain.Receipt;
import com.hedgebenefits.domain.User;
import com.hedgebenefits.util.HibernateUtils;
import org.hibernate.LockMode;
import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sureshsharma
 * Date: 17/06/2013
 * Time: 19:40
 * To change this template use File | Settings | File Templates.
 */
public class WorkingWithObjects {
    public static void main(String... args) throws InterruptedException {

        //Admin Created in session 0
        Session session0 = HibernateUtils.sessionFactory.openSession();
        session0.beginTransaction();
        Admin admin = createAdmin();
        admin.setReceipts(getRecepits(admin));
        session0.save(admin);
        session0.getTransaction().commit();
        session0.close();

        //Admin Created in session 1
        Session session = HibernateUtils.sessionFactory.openSession();
        session.beginTransaction();
        admin = (Admin) session.get(Admin.class, 1L);
        User user = new User("someUer", "someCat");
        admin.setUser(user);
        session.getTransaction().commit();
        session.close();


        Session session2 = HibernateUtils.sessionFactory.openSession();
//        session2.beginTransaction();

        Admin admin1 = (Admin) session2.load(Admin.class, 1L);
//        session2.update(admin);

//        session2.getTransaction().commit();
        session2.close();



//        System.out.println("session2: after persistant context close, receopits: " + admin.getId());



    }

    private static Admin createAdmin() {
        Admin admin = new Admin();
        admin.setUsername("AdminUser");
        admin.setPassword("adminPassword");
        return admin;
    }

    private static List<Receipt> getRecepits(Admin admin) {
        List<Receipt> recepits = new ArrayList<Receipt>();
        Receipt receipt1 = new Receipt();
        receipt1.setReceiptName("recepitggg1");
        receipt1.setAdmin(admin);
        recepits.add(receipt1);

        Receipt receipt2 = new Receipt();
        receipt2.setReceiptName("recepit2");
        receipt2.setAdmin(admin);
        recepits.add(receipt2);

        return recepits;
    }
}
