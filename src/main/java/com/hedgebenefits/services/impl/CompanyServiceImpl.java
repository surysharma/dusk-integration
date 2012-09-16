package com.hedgebenefits.services.impl;

import com.hedgebenefits.daos.CompanyDao;
import com.hedgebenefits.domain.Company;
import com.hedgebenefits.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {


    private CompanyDao companyDao;

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public void register(Company company) {
        companyDao.save(company);
    }

    @Override
    public List<Company> listAllCompanies() {
        return companyDao.listAllCompanies();
    }
}
