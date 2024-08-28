package com.app.chronos.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@ToString @EqualsAndHashCode
public class User {

  @Id
  @Getter @Setter @Column(name = "id")
  private int id;

  @Getter @Setter @Column(name = "username")
  private String username;

  @Getter @Setter @Column(name = "email")
  private String email;

  @Getter @Setter @Column(name = "password")
  private String password;

  @Getter @Setter @Column(name = "role")
  private String role;

}