package com.hedgebenefits.services;

import com.hedgebenefits.daos.AdminDao;
import com.hedgebenefits.domain.Admin;
import com.hedgebenefits.services.impl.AdminServiceImpl;
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
public class AdminServiceTest {

    @Mock
    private AdminDao adminDao;

    @InjectMocks
    private AdminService adminService = new AdminServiceImpl(adminDao);

    @Before
    public void setup() {

    }

    @Test
    public void shouldInvokeDao() {
        // When
        Admin admin = adminBuilder().build();
        adminService.register(admin);

        // Then
        verify(adminDao).save(admin);
    }


}
