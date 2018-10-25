package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.TestRole;

import com.example.bootTest.common.mapper.GenericMapper;

import java.util.List;

public interface TestRoleMapper extends GenericMapper<TestRole, Long> {
    int deleteByPrimaryKey(Long id);

    int insert(TestRole record);

    int insertSelective(TestRole record);

    TestRole selectByPrimaryKey(Long id);
    List<TestRole> selectUserRoles(Long userId);

    int updateByPrimaryKeySelective(TestRole record);

    int updateByPrimaryKey(TestRole record);
}
