package com.hedgebenefits.services;

import com.hedgebenefits.daos.AdminDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
    private AdminService adminService;

    @Before
    public void setup() {

    }

    @Test
    public void should() {
        Assert.fail("not yet implemented!!!");
    }
}
