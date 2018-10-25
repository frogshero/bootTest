package com.example.bootTest.app.db.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.bootTest.app.db.entity.TestRole;
import com.example.bootTest.app.db.dao.TestRoleMapper;
import com.example.bootTest.common.mapper.GenericMapper;
import com.example.bootTest.common.mapper.GenericRepository;

import java.util.List;

@Repository
public class TestRoleRepo extends GenericRepository<TestRole, Long> {
  @Autowired
  private TestRoleMapper mapper;
  
  @Override
  protected GenericMapper<TestRole, Long> getGenericMapper() {
    return mapper;
  }

  public List<TestRole> selectUserRoles(Long userId) {
    return mapper.selectUserRoles(userId);
  }
}

