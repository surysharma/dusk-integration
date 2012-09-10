package com.hedgebenefits.services.impl;

import com.hedgebenefits.daos.AdminDao;
import com.hedgebenefits.domain.Admin;
import com.hedgebenefits.domain.Sector;
import com.hedgebenefits.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {


    private AdminDao adminDao;

    @Autowired
    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public void register(Admin admin) {

        List<Sector> sectors = newArrayList(getSector("sector1"), getSector("sector2"), getSector("sector3"));

        admin.setSectors(sectors);
        adminDao.save(admin);
    }

    private Sector getSector(String name) {
        Sector sector = new Sector();
        sector.setName(name);
        return sector;
    }

    @Override
    public List<Admin> listAllAdmins() {
        return adminDao.listAllAdmins();
    }
}
