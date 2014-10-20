package de.mosaic4cap.webapp.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by svenklemmer on 19.10.14.
 * <p>
 * User used to log into mosaic4cap webapp
 */
public class SecurityUser extends User implements UserDetails {
  private static final Logger LOGGER = Logger.getLogger(SecurityUser.class);

  public SecurityUser(User user) {
    if (user != null) {
      this.setId(user.getId());
      this.setName(user.getName());
      this.setEmail(user.getEmail());
      this.setPassword(user.getPassword());
      this.setDob(user.getDob());
      this.setRoles(user.getRoles());
      LOGGER.debug("User has Roles " + user.getRoles());
    }
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> authorities = new ArrayList<>();
    Set<Role> userRoles = this.getRoles();
    if (userRoles != null) {
      for (Role role : userRoles) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
        authorities.add(authority);
      }
    }
    return authorities;
  }

  @Override
  public String getPassword() {
    return super.getPassword();
  }

  @Override
  public String getUsername() {
    return super.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}