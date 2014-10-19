package de.mosaic4cap.webapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by svenklemmer on 19.10.14.
 *
 * CustomUserDetaisService uses UserDetailsReppository to access database
 * and get user by there usernames
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserDetailsRepository repo;

  @Override
  public UserDetails loadUserByUsername(String userName)
      throws UsernameNotFoundException {
    User user = repo.findByEmail(userName);
    if(user == null){
      throw new UsernameNotFoundException("UserName "+userName+" not found");
    }
    return new SecurityUser(user);
  }
}
