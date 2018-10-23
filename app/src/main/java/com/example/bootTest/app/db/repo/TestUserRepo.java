package com.example.bootTest.app.db.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.bootTest.app.db.entity.TestUser;
import com.example.bootTest.app.db.dao.TestUserMapper;
import com.example.bootTest.app.db.generic.GenericMapper;
import com.example.bootTest.app.db.generic.GenericRepository;

@Repository
public class TestUserRepo extends GenericRepository<TestUser, Long> {
  @Autowired
  private TestUserMapper mapper;
  
  @Override
  protected GenericMapper<TestUser, Long> getGenericMapper() {
    return mapper;
  }

  public TestUser selectByName(String userName) {
    return mapper.selectByName(userName);
  }
}

