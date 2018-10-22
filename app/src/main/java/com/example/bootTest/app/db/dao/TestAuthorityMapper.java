package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.TestAuthority;

public interface TestAuthorityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestAuthority record);

    int insertSelective(TestAuthority record);

    TestAuthority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestAuthority record);

    int updateByPrimaryKey(TestAuthority record);
}