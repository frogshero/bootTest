package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.TestAuthority;

import com.example.bootTest.common.mapper.GenericMapper;

public interface TestAuthorityMapper extends GenericMapper<TestAuthority, Long> {
    int deleteByPrimaryKey(Long id);

    int insert(TestAuthority record);

    int insertSelective(TestAuthority record);

    TestAuthority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestAuthority record);

    int updateByPrimaryKey(TestAuthority record);
}
