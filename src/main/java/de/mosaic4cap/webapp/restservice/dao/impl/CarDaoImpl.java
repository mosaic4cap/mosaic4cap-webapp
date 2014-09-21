package de.mosaic4cap.webapp.restservice.dao.impl;

import de.mosaic4cap.webapp.restservice.dao.CarDao;
import de.mosaic4cap.webapp.stereotypes.annotation.Dao;
import de.mosaic4cap.webapp.stereotypes.domain.Car;
import org.apache.log4j.Logger;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Dao
public class CarDaoImpl extends GenericHibernateDaoImpl<Car> implements CarDao {
    private static final Logger LOGGER = Logger.getLogger(CarDaoImpl.class);
}

