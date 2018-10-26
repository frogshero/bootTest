package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.UserRole;

import com.example.bootTest.common.mapper.GenericMapper;

public interface UserRoleMapper extends GenericMapper<UserRole, Long> {
    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}
