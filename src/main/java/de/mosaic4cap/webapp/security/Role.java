package de.mosaic4cap.webapp.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by svenklemmer on 19.10.14.
 * <p>
 * Roles for different user
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_id")
  private Integer id;

  @ManyToOne
  @JoinColumn
  private User user;

  @Column(name = "role_name", nullable = false)
  private String roleName;

  public Role() {
  }

  public Role(String aRoleName) {
    this.roleName = aRoleName;
  }

  public Role(Integer aId, String aRoleName) {
    this.id = aId;
    this.roleName = aRoleName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer aId) {
    this.id = aId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String aRoleName) {
    this.roleName = aRoleName;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User aUser) {
    user = aUser;
  }

  @Override
  public String toString() {
    return roleName;
  }
}