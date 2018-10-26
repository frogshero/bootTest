package com.example.bootTest.app.service;

import com.example.bootTest.app.db.entity.Role;
import com.example.bootTest.app.db.entity.User;
import com.example.bootTest.app.db.repo.RoleRepo;
import com.example.bootTest.app.db.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepo userRepo;
  @Autowired
  private RoleRepo roleRepo;

  public User getUser(String userName) {
    return userRepo.selectByName(userName);
  }

  public User getUserById(Long id) {
    return userRepo.selectByPrimaryKey(id);
  }

  public List<Role> getUserRoles(Long userId) {
    return roleRepo.selectUserRoles(userId);
  }
}
