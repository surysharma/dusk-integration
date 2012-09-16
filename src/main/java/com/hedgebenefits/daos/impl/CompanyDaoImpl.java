package com.hedgebenefits.daos.impl;

import com.hedgebenefits.daos.CompanyDao;
import com.hedgebenefits.domain.Company;
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
public class CompanyDaoImpl implements CompanyDao {

    private SessionFactory sessionFactory;

    @Autowired
    public CompanyDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Company company) {
        sessionFactory.getCurrentSession().save(company);
    }

    @Override
    public boolean isExistingUser(Company company) {
        return sessionFactory.getCurrentSession().get(Company.class, company.getId()) != null ? true: false;

    }

    @Override
    public void updateExisting(Company company) {
        sessionFactory.getCurrentSession().update(company);
    }

    @Override
    public List<Company> listAllCompanies() {
        List<Company> companyList = sessionFactory.getCurrentSession().createCriteria(Company.class)
                .setMaxResults(5)
                .list();
        return companyList;
    }
}
