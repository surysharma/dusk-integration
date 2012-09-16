package com.hedgebenefits.daos.impl;

import com.hedgebenefits.daos.SectorDao;
import com.hedgebenefits.domain.Sector;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 03/07/2012
 * Time: 07:15
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class SectorDaoImpl implements SectorDao {

    private SessionFactory sessionFactory;

    @Autowired
    public SectorDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Sector sector) {
        sessionFactory.getCurrentSession().save(sector);
    }

    @Override
    public List<Sector> listAllSectors() {
        return sessionFactory.getCurrentSession().createCriteria(Sector.class).list();
    }
}
