package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.RoleAuthority;

import com.example.bootTest.common.mapper.GenericMapper;

public interface RoleAuthorityMapper extends GenericMapper<RoleAuthority, Long> {
    int deleteByPrimaryKey(Long id);

    int insert(RoleAuthority record);

    int insertSelective(RoleAuthority record);

    RoleAuthority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleAuthority record);

    int updateByPrimaryKey(RoleAuthority record);
}
