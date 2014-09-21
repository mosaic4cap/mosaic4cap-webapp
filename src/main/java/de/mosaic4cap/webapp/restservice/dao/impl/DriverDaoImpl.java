package de.mosaic4cap.webapp.restservice.dao.impl;

import de.mosaic4cap.webapp.restservice.dao.DriverDao;
import de.mosaic4cap.webapp.stereotypes.annotation.Dao;
import de.mosaic4cap.webapp.stereotypes.domain.Driver;
import org.apache.log4j.Logger;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Dao
public class DriverDaoImpl extends GenericHibernateDaoImpl<Driver> implements DriverDao {
    private static final Logger LOGGER = Logger.getLogger(DriverDaoImpl.class);
}
