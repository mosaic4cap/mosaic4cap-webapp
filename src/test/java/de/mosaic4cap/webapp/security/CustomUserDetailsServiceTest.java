package de.mosaic4cap.webapp.security;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by svenklemmer on 19.10.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class CustomUserDetailsServiceTest {
  private static final Logger LOGGER = Logger.getLogger(CustomUserDetailsServiceTest.class);

  @Autowired
  private CustomUserDetailsService service;

  @Test
  public void testCanFindUserByName() throws Exception {
    UserDetails remote = service.loadUserByUsername("admin@admin.de");
    assertThat(remote.getUsername(), is("admin@admin.de"));
  }
}
