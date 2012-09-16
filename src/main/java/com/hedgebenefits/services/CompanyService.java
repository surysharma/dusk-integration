package com.hedgebenefits.services;

import com.hedgebenefits.domain.Company;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 01/07/2012
 * Time: 21:00
 * To change this template use File | Settings | File Templates.
 */
public interface CompanyService {
    void register(Company company);
    List<Company> listAllCompanies();

}
