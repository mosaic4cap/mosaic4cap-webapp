package de.mosaic4cap.webapp.base.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by svenklemmer on 16.10.14.
 */

public class HomeController {
  private static final Logger LOGGER = Logger.getLogger(HomeController.class);

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String indexPage() throws Exception {
    return "index";
  }

  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public String homePage() throws Exception {
    return "redirect:index";
  }

  @RequestMapping(value = "/start", method = RequestMethod.GET)
  public String startPage() throws Exception {
    return "redirect:index";
  }
}
