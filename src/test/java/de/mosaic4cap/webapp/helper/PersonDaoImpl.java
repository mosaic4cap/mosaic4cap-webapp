package de.mosaic4cap.webapp.helper;

import org.apache.log4j.Logger;

import de.mosaic4cap.webapp.restservice.dao.impl.HibernateDao;
import de.mosaic4cap.webapp.stereotypes.annotation.Dao;

/**
 * Created by svenklemmer on 25.09.14.
 */
@Dao
public class PersonDaoImpl extends HibernateDao<Person, Long> implements PersonDao {
  private static final Logger LOGGER = Logger.getLogger(PersonDaoImpl.class);
}
