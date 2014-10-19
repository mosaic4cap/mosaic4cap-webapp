package de.mosaic4cap.webapp.security;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by svenklemmer on 19.10.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class UserDetailsRepositoryTest {
  private static final Logger LOGGER = Logger.getLogger(UserDetailsRepository.class);

  @Autowired
  private UserDetailsRepository repo;

  @Test
  public void testCanFindUserByEmail() throws Exception {
    User sample = new User("admin", "admin@admin.de", "password", new Date());

    Set<Role> roles = new HashSet<>();
    roles.add(new Role("ADMIN"));
    sample.setRoles(roles);
    User user = repo.findByEmail(sample.getEmail());

    assertThat(user, is(notNullValue()));
    assertThat(user.getName(), is(sample.getName()));
    assertThat(user.getEmail(), is(sample.getEmail()));
    assertThat(user.getPassword(), is(sample.getPassword()));
    assertThat(user.getRoles().size(), is(sample.getRoles().size()));

    /*for (Role r : user.getRoles()) {
      assertThat(sample.getRoles().contains(r), is(true));
    }*/
  }
}
