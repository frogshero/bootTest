package com.example.bootTest.app.db.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.bootTest.app.db.entity.TestAuthority;
import com.example.bootTest.app.db.dao.TestAuthorityMapper;
import com.example.bootTest.common.mapper.GenericMapper;
import com.example.bootTest.common.mapper.GenericRepository;

@Repository
public class TestAuthorityRepo extends GenericRepository<TestAuthority, Long> {
  @Autowired
  private TestAuthorityMapper mapper;
  
  @Override
  protected GenericMapper<TestAuthority, Long> getGenericMapper() {
    return mapper;
  }
}

