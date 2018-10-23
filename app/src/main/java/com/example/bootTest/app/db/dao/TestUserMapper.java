package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.TestUser;

import com.example.bootTest.app.db.generic.GenericMapper;

public interface TestUserMapper extends GenericMapper<TestUser, Long> {
    int deleteByPrimaryKey(Long id);

    int insert(TestUser record);

    int insertSelective(TestUser record);

    TestUser selectByPrimaryKey(Long id);
    TestUser selectByName(String userName);

    int updateByPrimaryKeySelective(TestUser record);

    int updateByPrimaryKey(TestUser record);
}
