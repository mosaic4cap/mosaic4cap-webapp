package de.mosaic4cap.webapp.restservice.controller;

import de.mosaic4cap.webapp.core.AbstractRestController;
import de.mosaic4cap.webapp.restservice.services.StoreAccountService;
import de.mosaic4cap.webapp.stereotypes.entities.StoreAccount;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Lobedan on 30.08.2014.
 */
@RestController
public class StoreAccountRestController extends AbstractRestController {
    private static final Logger LOGGER = Logger.getLogger(StoreAccountRestController.class);

    @Autowired
    private StoreAccountService storeAccountService;

    @RequestMapping(value = "/{store}/storeaccount/{id}", method = RequestMethod.GET)
    public StoreAccount get(
            @PathVariable("store") String store,
            @PathVariable("id") long id,
            @RequestParam(required = false) String mql
    ) throws Exception {
        return storeAccountService.get(id);
    }


    @RequestMapping(value = "/{store}/storeaccount", method = RequestMethod.GET)
    public List<StoreAccount> getAll(
            @PathVariable("store") String store,
            @RequestParam(required = false) String mql
    ) throws Exception {
        return storeAccountService.getAll();
    }

    @RequestMapping(value = "/{store}/storeaccount/insert", method = RequestMethod.POST)
    public StoreAccount insert(
            @PathVariable("store") String store,
            StoreAccount insertObj
    ) throws Exception {
        return storeAccountService.insert(insertObj);
    }

    @RequestMapping(value = "/{store}/storeaccount/update", method = RequestMethod.PUT)
    public StoreAccount update(
            @PathVariable("store") String store,
            StoreAccount updateObj
    ) throws Exception {
        return storeAccountService.update(updateObj);
    }

    @RequestMapping(value = "/{store}/storeaccount/delete/{id}", method = RequestMethod.DELETE)
    public void delete(
            @PathVariable("store") String store,
            @PathVariable("id") long objId
    ) throws Exception {
        storeAccountService.delete(objId);
    }


    @RequestMapping(value = "/{store}/storeaccount/delete", method = RequestMethod.DELETE)
    public void delete(
            @PathVariable("store") String store,
            StoreAccount deleteObj
    ) throws Exception {
        storeAccountService.delete(deleteObj);
    }
}
