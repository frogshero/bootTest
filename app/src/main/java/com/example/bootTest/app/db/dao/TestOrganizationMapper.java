package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.TestOrganization;

public interface TestOrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestOrganization record);

    int insertSelective(TestOrganization record);

    TestOrganization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestOrganization record);

    int updateByPrimaryKey(TestOrganization record);
}