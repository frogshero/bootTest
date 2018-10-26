package com.example.bootTest.app.db.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.bootTest.app.db.entity.RoleAuthority;
import com.example.bootTest.app.db.dao.RoleAuthorityMapper;
import com.example.bootTest.common.mapper.GenericMapper;
import com.example.bootTest.common.mapper.GenericRepository;

@Repository
public class RoleAuthorityRepo extends GenericRepository<RoleAuthority, Long> {
  @Autowired
  private RoleAuthorityMapper mapper;

  @Override
  protected GenericMapper<RoleAuthority, Long> getGenericMapper() {
    return mapper;
  }
}

