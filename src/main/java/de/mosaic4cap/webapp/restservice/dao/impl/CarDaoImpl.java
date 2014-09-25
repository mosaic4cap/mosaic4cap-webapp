package de.mosaic4cap.webapp.restservice.dao.impl;

import de.mosaic4cap.webapp.restservice.dao.CarDao;
import de.mosaic4cap.webapp.stereotypes.annotation.Dao;
import de.mosaic4cap.webapp.stereotypes.entities.Car;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Dao
public class CarDaoImpl extends HibernateDao<Car, Long> implements CarDao { }

