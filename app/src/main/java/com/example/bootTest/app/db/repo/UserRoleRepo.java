package com.example.bootTest.app.db.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.bootTest.app.db.entity.UserRole;
import com.example.bootTest.app.db.dao.UserRoleMapper;
import com.example.bootTest.common.mapper.GenericMapper;
import com.example.bootTest.common.mapper.GenericRepository;

@Repository
public class UserRoleRepo extends GenericRepository<UserRole, Long> {
  @Autowired
  private UserRoleMapper mapper;

  @Override
  protected GenericMapper<UserRole, Long> getGenericMapper() {
    return mapper;
  }
}

