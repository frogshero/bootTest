package com.example.bootTest.web.security;

import com.example.bootTest.app.db.entity.TestRole;
import com.example.bootTest.app.db.entity.TestUser;
import com.example.bootTest.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestUserService implements UserDetailsService {

  @Autowired
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    TestUser u = userService.getTestUser(username);
    Assert.notNull(u, "No such a user");
    List<TestRole> roleList = userService.getUserRoles(u.getId());
    List<GrantedAuthority> granted = roleList.stream().map(r -> new SimpleGrantedAuthority(r.getRoleName())).collect(Collectors.toList());
    LoginUser user = new LoginUser(u.getUserName(), u.getPwd(), u.getEnabled() == 1, u.getOrgId(), granted);
    return user;
  }
}
