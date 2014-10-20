package de.mosaic4cap.webapp.security;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by svenklemmer on 19.10.14.
 * <p>
 * Entitiy for a user dataset in database
 */
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  private Date dob;

  /*@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")*/
  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(String aName, String aEmail, String aPassword, Date aDob) {
    this.name = aName;
    this.email = aEmail;
    this.password = aPassword;
    this.dob = aDob;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", email=" + email
           + ", dob=" + dob + "]";
  }

  public int getId() {
    return id;
  }

  public void setId(int aId) {
    this.id = aId;
  }

  public String getName() {
    return name;
  }

  public void setName(String aName) {
    this.name = aName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String aEmail) {
    this.email = aEmail;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String aPassword) {
    this.password = aPassword;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date aDob) {
    this.dob = aDob;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> aRoles) {
    this.roles = aRoles;
  }
}