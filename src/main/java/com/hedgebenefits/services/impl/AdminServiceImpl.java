package com.hedgebenefits.services.impl;

import com.hedgebenefits.daos.AdminDao;
import com.hedgebenefits.domain.Admin;
import com.hedgebenefits.services.AdminService;

public class AdminServiceImpl implements AdminService {


    private AdminDao adminDao;

    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public void register(Admin admin) {
        adminDao.save(admin);
    }
}
