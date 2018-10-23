package com.example.bootTest.app.service;

import com.example.bootTest.app.db.entity.TestRole;
import com.example.bootTest.app.db.entity.TestUser;
import com.example.bootTest.app.db.repo.TestRoleRepo;
import com.example.bootTest.app.db.repo.TestUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private TestUserRepo testUserRepo;
  @Autowired
  private TestRoleRepo testRoleRepo;

  public TestUser getTestUser(String userName) {
    return testUserRepo.selectByName(userName);
  }

  public TestUser getUserById(Long id) {
    return testUserRepo.selectByPrimaryKey(id);
  }

  public List<TestRole> getUserRoles(Long userId) {
    return testRoleRepo.selectUserRoles(userId);
  }
}
