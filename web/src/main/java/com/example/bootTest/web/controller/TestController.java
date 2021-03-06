package com.example.bootTest.web.controller;

import com.example.bootTest.app.db.entity.User;
import com.example.bootTest.app.service.UserService;
import com.example.bootTest.common.reponse.ApiResult;
import com.example.bootTest.web.security.LoginUser;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Timed
@RestController
public class TestController {

  @Autowired
  private UserService testService;

//  @PostMapping("/afterLogin")
//  public String postAfterLogin(HttpServletRequest req) {
//    return req.getRequestURI();
//  }

  @PreAuthorize("hasPermission(#id, 'read')")
  @GetMapping("/test/{id}")
  public String getInfo(@PathVariable Long id) {
    return id.toString();
  }

  @GetMapping("/user/{id}")
  public ApiResult<User> getUserInfo(@PathVariable Long id) {
    //password字段不能返回
    User u = testService.getUserById(id);
    Assert.notNull(u, "Error User Id");
    u.setPwd(null);
    return new ApiResult(u);
  }

  @GetMapping("/admin/{id}")
  public String getAdminInfo(@AuthenticationPrincipal LoginUser currentUser, @PathVariable Long id) {
    return currentUser.getOrgId().toString();
  }
}
