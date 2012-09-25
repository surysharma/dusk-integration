package com.hedgebenefits.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

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
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
}
