package com.hedgebenefits.daos;

import com.hedgebenefits.domain.Sector;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 01/07/2012
 * Time: 21:05
 * To change this template use File | Settings | File Templates.
 */
public interface SectorDao {

    void save(Sector company);

    List<Sector> listAllSectors();
}
