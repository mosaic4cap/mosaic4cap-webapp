package de.mosaic4cap.webapp.restservice.services.impl;

import de.mosaic4cap.webapp.restservice.dao.DriverDao;
import de.mosaic4cap.webapp.restservice.services.DriverService;
import de.mosaic4cap.webapp.stereotypes.domain.Driver;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Service
public class DriverServiceImpl extends AbstractGenericService<Driver> implements DriverService {
    private static final Logger LOGGER = Logger.getLogger(DriverServiceImpl.class);

    public DriverServiceImpl() { }
    @Autowired
    public DriverServiceImpl(DriverDao dao) {
        super.setDao(dao);
    }
}