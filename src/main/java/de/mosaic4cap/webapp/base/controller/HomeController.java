package de.mosaic4cap.webapp.base.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
  }, method = RequestMethod.GET)
  public String indexPage() throws Exception {
    return "index";
  }
}
