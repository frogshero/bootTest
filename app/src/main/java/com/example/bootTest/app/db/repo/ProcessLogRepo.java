package com.example.bootTest.app.db.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.bootTest.app.db.entity.ProcessLog;
import com.example.bootTest.app.db.dao.ProcessLogMapper;
import com.example.bootTest.common.mapper.GenericMapper;
import com.example.bootTest.common.mapper.GenericRepository;

@Repository
public class ProcessLogRepo extends GenericRepository<ProcessLog, Long> {
  @Autowired
  private ProcessLogMapper mapper;
  
  @Override
  protected GenericMapper<ProcessLog, Long> getGenericMapper() {
    return mapper;
  }
}

