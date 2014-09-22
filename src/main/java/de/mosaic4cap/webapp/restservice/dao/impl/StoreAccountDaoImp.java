package de.mosaic4cap.webapp.restservice.dao.impl;

import de.mosaic4cap.webapp.restservice.dao.StoreAccountDao;
import de.mosaic4cap.webapp.stereotypes.annotation.Dao;
import de.mosaic4cap.webapp.stereotypes.entities.StoreAccount;
import org.apache.log4j.Logger;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Dao
public class StoreAccountDaoImp extends GenericHibernateDaoImpl<StoreAccount> implements StoreAccountDao {
    private static final Logger LOGGER = Logger.getLogger(StoreAccountDaoImp.class);
}
