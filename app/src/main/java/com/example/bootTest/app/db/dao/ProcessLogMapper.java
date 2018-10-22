package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.ProcessLog;

public interface ProcessLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProcessLog record);

    int insertSelective(ProcessLog record);

    ProcessLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProcessLog record);

    int updateByPrimaryKey(ProcessLog record);
}