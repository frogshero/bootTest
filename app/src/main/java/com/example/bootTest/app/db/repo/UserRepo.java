package com.example.bootTest.app.db.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.bootTest.app.db.entity.User;
import com.example.bootTest.app.db.dao.UserMapper;
import com.example.bootTest.common.mapper.GenericMapper;
import com.example.bootTest.common.mapper.GenericRepository;

@Repository
public class UserRepo extends GenericRepository<User, Long> {
  @Autowired
  private UserMapper mapper;

  @Override
  protected GenericMapper<User, Long> getGenericMapper() {
    return mapper;
  }

  public User selectByName(String userName) {
    return mapper.selectByName(userName);
  }
}

