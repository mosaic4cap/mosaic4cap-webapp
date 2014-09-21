package de.mosaic4cap.webapp.chefui.controller;

import de.mosaic4cap.webapp.core.AbstractChefUIController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by svenklemmer on 16.09.14.
 * <p/>
 * Controller for all base views like dashboard
 */
@Controller
public class HomeController extends AbstractChefUIController {
    private static final Logger LOGGER = Logger.getLogger(HomeController.class);

    @RequestMapping("/")
    public String home() {
        return "chefui/test";
    }


    @RequestMapping("/storeaccount")
    public String storeAccount() {
        return "chefui/storeaccount";
    }
}
