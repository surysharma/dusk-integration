package com.hedgebenefits.util;

import com.hedgebenefits.domain.Company;
import com.hedgebenefits.domain.CompanySector;
import com.hedgebenefits.domain.Sector;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static com.google.common.collect.Lists.newArrayList;

public class DataFeeder {

    public static void main(String... args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("file:/projects/dusk-integration/src/main/webapp/WEB-INF/hedgebenefits-servlet.xml");
        SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(getSector("IT"));
        Sector agricultureSector = getSector("Agriculture");
        session.save(agricultureSector);
        session.save(getSector("Health"));


        Company comp1 = getCompany("comp1");

        CompanySector companySector = new CompanySector();
        companySector.setCompany(comp1);
        companySector.setSector(agricultureSector);
        comp1.setCompanySectors(newArrayList(companySector));
        session.save(comp1);
        
        session.getTransaction().commit();

        session.beginTransaction();
      
    }

    private static Company getCompany(String name) {
        Company company = new Company();
        company.setUsername(name);
        company.setPassword(name);
        return company;  //To change body of created methods use File | Settings | File Templates.
    }



    private static Sector getSector(String it) {
        Sector sector = new Sector();
        sector.setName(it);
        return sector;
    }
}
