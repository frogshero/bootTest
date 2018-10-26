package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.Role;

import com.example.bootTest.common.mapper.GenericMapper;

import java.util.List;

public interface RoleMapper extends GenericMapper<Role, Long> {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);
    List<Role> selectUserRoles(Long userId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}
