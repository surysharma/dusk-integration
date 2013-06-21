package com;

import com.hedgebenefits.domain.Admin;
import com.hedgebenefits.domain.Receipt;
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

//        Session session = HibernateUtils.sessionFactory.openSession();
//        session.beginTransaction();
//        Admin admin = (Admin) session.load(Admin.class, 2L);
//        session.evict(admin);
//        session.getTransaction().commit();
//        session.close();
//        Admin tempAdmin = admin;


        Session session2 = HibernateUtils.sessionFactory.openSession();
//        session2.beginTransaction();

        Admin admin1 = (Admin) session2.get(Admin.class, 2L);
//        session2.update(admin);

//        session2.getTransaction().commit();
        session2.close();



//        System.out.println("session2: after persistant context close, receopits: " + admin.getId());



    }

    private static List<Receipt> getRecepits() {
        List<Receipt> recepits = new ArrayList<Receipt>();
        Receipt receipt1 = new Receipt();
        receipt1.setReceiptName("recepitggg1");
        recepits.add(receipt1);

        Receipt receipt2 = new Receipt();
        receipt2.setReceiptName("recepit2");
        recepits.add(receipt2);

        return recepits;
    }
}
