package com.hedgebenefits.util;

import com.hedgebenefits.domain.Admin;
import com.hedgebenefits.domain.Receipt;
import com.hedgebenefits.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.ImprovedNamingStrategy;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 25/09/2012
 * Time: 19:35
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUtils {
    public static SessionFactory sessionFactory =
            new AnnotationConfiguration()
                    .addPackage("com.hedgebenefits.domain")
                    .addAnnotatedClass(Admin.class)
                    .addAnnotatedClass(Receipt.class)
                    .addAnnotatedClass(User.class)
                    .setNamingStrategy(new ImprovedNamingStrategy())
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
}
