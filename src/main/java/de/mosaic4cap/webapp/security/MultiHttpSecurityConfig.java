package de.mosaic4cap.webapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by svenklemmer on 18.10.14.
 *
 * Configuration for Spring Security mechanism
 * There are two parts of this config
 * The first one defines the configuration for mosaic4cap-restservice thats why theres
 * the @Order(1) annotation, this configured the use of HttpBasicAuth for any routes, which starts with /rest
 *
 * the second one is used after the HttpBasicAuth and uses a form to login into mosaic4cap
 * thats the path every "normal" user takes, when he enters mosaic4cap webapp
 *
 * The configureGlobal part is uses to define common usernames for both configurations
 * usernames are given from the persistence layer of mosaic4cap and a {@link de.mosaic4cap.webapp.security.CustomUserDetailsService}
 */
@Configuration
@EnableWebSecurity
public class MultiHttpSecurityConfig {

/*  @Autowired
  private DataSource dataSource;*/

  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {


    auth.userDetailsService(customUserDetailsService);
    /*auth

        .jdbcAuthentication()
        .dataSource(dataSource)
        .withDefaultSchema()
        .withUser("user").password("password").roles("USER").and()
        .withUser("admin").password("password").roles("USER", "ADMIN");*/
  }

  @Configuration
  @Order(1)
  public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
          .antMatcher("/rest/**")
          .authorizeRequests()
          .anyRequest().hasRole("ADMIN")
          .and()
          .httpBasic();
    }
  }

  @Configuration
  public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

      http.authorizeRequests()
          .antMatchers("/chefui/**").hasAnyRole("ADMIN", "CHEF")
          .antMatchers("/adminui/**").hasRole("ADMIN")
          .and()
          .formLogin().loginPage("/login").failureUrl("/login?error")
          .usernameParameter("username").passwordParameter("password")
          .and()

          .logout()
          .logoutUrl("/logout")
          .logoutSuccessUrl("/");
    }
  }
}