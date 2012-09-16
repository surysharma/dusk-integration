package com.hedgebenefits.services;

import com.hedgebenefits.daos.CompanyDao;
import com.hedgebenefits.domain.Company;
import com.hedgebenefits.services.impl.CompanyServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.hedgebenefits.builders.AdminBuilder.adminBuilder;
import static org.mockito.Mockito.verify;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 01/07/2012
 * Time: 21:01
 * To change this template use File | Settings | File Templates.
 */
@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceTest {

    @Mock
    private CompanyDao companyDao;

    @InjectMocks
    private CompanyService companyService = new CompanyServiceImpl(companyDao);

    @Before
    public void setup() {

    }

    @Test
    public void shouldInvokeDao() {
        // When
        Company company = adminBuilder().build();
        companyService.register(company);

        // Then
        verify(companyDao).save(company);
    }


}
