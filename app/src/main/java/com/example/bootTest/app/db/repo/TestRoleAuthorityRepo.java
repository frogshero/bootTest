package com.example.bootTest.app.db.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.bootTest.app.db.entity.TestRoleAuthority;
import com.example.bootTest.app.db.dao.TestRoleAuthorityMapper;
import com.example.bootTest.app.db.generic.GenericMapper;
import com.example.bootTest.app.db.generic.GenericRepository;

@Repository
public class TestRoleAuthorityRepo extends GenericRepository<TestRoleAuthority, Long> {
  @Autowired
  private TestRoleAuthorityMapper mapper;
  
  @Override
  protected GenericMapper<TestRoleAuthority, Long> getGenericMapper() {
    return mapper;
  }
}

