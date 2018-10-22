package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.TestRoleAuthority;

public interface TestRoleAuthorityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestRoleAuthority record);

    int insertSelective(TestRoleAuthority record);

    TestRoleAuthority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestRoleAuthority record);

    int updateByPrimaryKey(TestRoleAuthority record);
}