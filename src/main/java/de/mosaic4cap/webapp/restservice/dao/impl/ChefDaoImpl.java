package de.mosaic4cap.webapp.restservice.dao.impl;

import de.mosaic4cap.webapp.restservice.dao.ChefDao;
import de.mosaic4cap.webapp.stereotypes.annotation.Dao;
import de.mosaic4cap.webapp.stereotypes.domain.Chef;
import org.apache.log4j.Logger;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Dao
public class ChefDaoImpl extends GenericHibernateDaoImpl<Chef> implements ChefDao {
    private static final Logger LOGGER = Logger.getLogger(ChefDaoImpl.class);
}
