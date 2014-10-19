package de.mosaic4cap.webapp.security;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by svenklemmer on 19.10.14.
 */
public interface UserDetailsRepository extends CrudRepository<User, Integer> {

  public User findByEmail(String email);
}
