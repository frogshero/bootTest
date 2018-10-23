package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.ProcessLog;

import com.example.bootTest.app.db.generic.GenericMapper;

public interface ProcessLogMapper extends GenericMapper<ProcessLog, Long> {
    int deleteByPrimaryKey(Long id);

    int insert(ProcessLog record);

    int insertSelective(ProcessLog record);

    ProcessLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProcessLog record);

    int updateByPrimaryKey(ProcessLog record);
}
