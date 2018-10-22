package com.example.bootTest.web.security;

import com.example.bootTest.app.db.entity.TestUser;
import com.example.bootTest.app.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class TestUserService implements UserDetailsService {

  @Autowired
  private TestService testService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    TestUser u = testService.getTestUser(username);
    Assert.notNull(u, "No such a user");
    User user = new User(u.getUserName(), u.getPwd(), u.getEnabled() == 1, true, true, true, AuthorityUtils.NO_AUTHORITIES);
    return user;
  }
}
