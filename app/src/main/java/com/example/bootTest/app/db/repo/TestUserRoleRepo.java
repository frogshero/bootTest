package com.example.bootTest.app.db.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.bootTest.app.db.entity.TestUserRole;
import com.example.bootTest.app.db.dao.TestUserRoleMapper;
import com.example.bootTest.common.mapper.GenericMapper;
import com.example.bootTest.common.mapper.GenericRepository;

@Repository
public class TestUserRoleRepo extends GenericRepository<TestUserRole, Long> {
  @Autowired
  private TestUserRoleMapper mapper;
  
  @Override
  protected GenericMapper<TestUserRole, Long> getGenericMapper() {
    return mapper;
  }
}

