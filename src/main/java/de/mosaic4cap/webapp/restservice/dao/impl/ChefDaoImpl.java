package de.mosaic4cap.webapp.restservice.dao.impl;

import de.mosaic4cap.webapp.restservice.dao.ChefDao;
import de.mosaic4cap.webapp.stereotypes.annotation.Dao;
import de.mosaic4cap.webapp.stereotypes.entities.Chef;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Dao
public class ChefDaoImpl extends HibernateDao<Chef, Long> implements ChefDao { }
