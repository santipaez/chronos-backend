package com.app.chronos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@ToString
@EqualsAndHashCode
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter @Setter @Column(name = "id")
  private Integer id;

  @Getter @Setter
  @Column(name = "username", nullable = false, updatable = true)
  @Size(min = 6, message = "Username must have at least 6 characters.")
  private String username;

  @Getter @Setter
  @Column(name = "email", nullable = false, unique = true, updatable = false)
  @Email(message = "Email should be valid.")
  private String email;

  @Getter @Setter
  @Column(name = "password", nullable = false)
  @Size(min = 6, message = "Password must have at least 6 characters.")
  @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).+$", 
          message = "Password must contain at least one uppercase letter and one number.")
  private String password;

  @Enumerated(EnumType.STRING)
  @Getter @Setter @Column(name = "role")
  private Role role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
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
