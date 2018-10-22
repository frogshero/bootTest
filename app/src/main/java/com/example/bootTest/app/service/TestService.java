package com.example.bootTest.app.service;

import com.alibaba.fastjson.JSONObject;
import com.example.bootTest.app.db.dao.TestUserMapper;
import com.example.bootTest.app.db.entity.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

  @Autowired
  private TestUserMapper testUserMapper;

  public TestUser getTestUser(String userName) {
    return testUserMapper.selectByName(userName);
  }
}
