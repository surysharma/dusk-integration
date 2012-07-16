package com.hedgebenefits.services.impl;

import com.hedgebenefits.daos.AdminDao;
import com.hedgebenefits.domain.Admin;
import com.hedgebenefits.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AdminServiceImpl implements AdminService {


    private AdminDao adminDao;

    @Autowired
    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public void register(Admin admin) {
        adminDao.save(admin);
    }

    @Override
    public Set<Admin> listAllAdmins() {
        return adminDao.listAllAdmins();
    }
}
