package de.mosaic4cap.webapp.restservice.dao.impl;

import de.mosaic4cap.webapp.restservice.dao.DriverDao;
import de.mosaic4cap.webapp.stereotypes.annotation.Dao;
import de.mosaic4cap.webapp.stereotypes.entities.Driver;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Dao
public class DriverDaoImpl extends HibernateDao<Driver, Long> implements DriverDao { }