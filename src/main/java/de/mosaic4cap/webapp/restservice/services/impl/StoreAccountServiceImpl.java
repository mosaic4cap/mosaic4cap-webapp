package de.mosaic4cap.webapp.restservice.services.impl;

import de.mosaic4cap.webapp.restservice.dao.StoreAccountDao;
import de.mosaic4cap.webapp.restservice.services.StoreAccountService;
import de.mosaic4cap.webapp.stereotypes.domain.StoreAccount;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Service
public class StoreAccountServiceImpl extends AbstractGenericService<StoreAccount> implements StoreAccountService {
    private static final Logger LOGGER = Logger.getLogger(StoreAccountServiceImpl.class);

    public StoreAccountServiceImpl() { }
    @Autowired
    public StoreAccountServiceImpl(StoreAccountDao dao) {
        super.setDao(dao);
    }
}
