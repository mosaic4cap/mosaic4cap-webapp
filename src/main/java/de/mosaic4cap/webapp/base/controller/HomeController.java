package de.mosaic4cap.webapp.base.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by svenklemmer on 16.10.14.
 */
@Controller
public class HomeController {
  private static final Logger LOGGER = Logger.getLogger(HomeController.class);

  @RequestMapping(value = {
      "/",
      "/home",
      "/start",
      "/index"
  }, method = RequestMethod.GET)
  public String indexPage() throws Exception {
    LOGGER.debug("Accessing indexPage()");
    return "index";
  }

  @RequestMapping(value = {
      "/login",
      "/anmelden",
  }, method = RequestMethod.GET)
  public String loginPage(@RequestParam(value = "error", required = false) String error, Model model) {
    LOGGER.debug("Accessing loginPage()");
    model.addAttribute("loginError", (error != null));
    return "login";
  }

 /* @RequestMapping(value = {
      "/logout",
      "/abmelden",
  }, method = RequestMethod.GET)
  public String logout() {
    return "logout";

  }*/
}
