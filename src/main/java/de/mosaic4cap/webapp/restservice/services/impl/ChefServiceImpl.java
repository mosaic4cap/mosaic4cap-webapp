package de.mosaic4cap.webapp.restservice.services.impl;

import de.mosaic4cap.webapp.restservice.dao.ChefDao;
import de.mosaic4cap.webapp.restservice.services.ChefService;
import de.mosaic4cap.webapp.stereotypes.domain.Chef;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Service
public class ChefServiceImpl extends AbstractGenericService<Chef> implements ChefService {
    private static final Logger LOGGER = Logger.getLogger(ChefServiceImpl.class);

    public ChefServiceImpl() { }
    @Autowired
    public ChefServiceImpl(ChefDao dao) {
        super.setDao(dao);
    }
}