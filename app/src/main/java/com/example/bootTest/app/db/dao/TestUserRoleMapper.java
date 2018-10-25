package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.TestUserRole;

import com.example.bootTest.common.mapper.GenericMapper;

public interface TestUserRoleMapper extends GenericMapper<TestUserRole, Long> {
    int deleteByPrimaryKey(Long id);

    int insert(TestUserRole record);

    int insertSelective(TestUserRole record);

    TestUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestUserRole record);

    int updateByPrimaryKey(TestUserRole record);
}
