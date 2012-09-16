package com.hedgebenefits.services.impl;

import com.hedgebenefits.daos.SectorDao;
import com.hedgebenefits.domain.Sector;
import com.hedgebenefits.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SectorServiceImpl implements SectorService {


    private SectorDao sectorDao;

    @Autowired
    public SectorServiceImpl(SectorDao sectorDao) {
        this.sectorDao = sectorDao;
    }

    @Override
    public void save(Sector sector) {
        sectorDao.save(sector);
    }

    @Override
    public List<Sector> listAllSectors() {
        return sectorDao.listAllSectors();
    }
}
