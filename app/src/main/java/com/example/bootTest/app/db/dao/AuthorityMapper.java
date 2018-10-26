package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.Authority;

import com.example.bootTest.common.mapper.GenericMapper;

public interface AuthorityMapper extends GenericMapper<Authority, Long> {
    int deleteByPrimaryKey(Long id);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
}
