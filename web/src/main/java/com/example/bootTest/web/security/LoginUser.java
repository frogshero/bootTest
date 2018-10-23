package com.example.bootTest.web.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Data
public class LoginUser extends User {
  private Long orgId;

  public LoginUser(String username, String password, boolean enabled,
                   Long orgId, Collection<? extends GrantedAuthority> authorities) {
    super(username, password, enabled, true, true, true, authorities);
    this.orgId = orgId;
  }

  private LoginUser() {
    super("", "", true, true, true, true, AuthorityUtils.NO_AUTHORITIES);
  }
}
