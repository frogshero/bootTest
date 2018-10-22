package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.TestUser;

public interface TestUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestUser record);

    int insertSelective(TestUser record);

    TestUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestUser record);

    int updateByPrimaryKey(TestUser record);

    TestUser selectByName(String userName);
}