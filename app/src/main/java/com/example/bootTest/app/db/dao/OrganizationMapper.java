package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.Organization;

import com.example.bootTest.common.mapper.GenericMapper;

public interface OrganizationMapper extends GenericMapper<Organization, Long> {
    int deleteByPrimaryKey(Long id);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
}
