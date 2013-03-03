package com.hedgebenefits.daos.repository;

import com.hedgebenefits.daos.CompanyDao;
import com.hedgebenefits.domain.jpadomain.Company;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * User: sureshsharma
 * Date: 01/03/2013
 * Time: 19:19
 * To change this template use File | Settings | File Templates.
 */
public interface CompanyRepository extends CrudRepository<Company, Long>, CompanyDao {
}
