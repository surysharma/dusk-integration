package com.hedgebenefits.daos;

import com.hedgebenefits.domain.Company;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 01/07/2012
 * Time: 21:05
 * To change this template use File | Settings | File Templates.
 */
public interface CompanyDao {

    void save(Company company);

    boolean isExistingUser(Company company);

    void updateExisting(Company company);

    List<Company> listAllCompanies();
}
