package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.User;

import com.example.bootTest.common.mapper.GenericMapper;

public interface UserMapper extends GenericMapper<User, Long> {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);
    User selectByName(String userName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
