package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.TestRole;

public interface TestRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestRole record);

    int insertSelective(TestRole record);

    TestRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestRole record);

    int updateByPrimaryKey(TestRole record);
}