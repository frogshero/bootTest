package com.example.bootTest.app.db.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.bootTest.app.db.entity.Role;
import com.example.bootTest.app.db.dao.RoleMapper;
import com.example.bootTest.common.mapper.GenericMapper;
import com.example.bootTest.common.mapper.GenericRepository;

import java.util.List;

@Repository
public class RoleRepo extends GenericRepository<Role, Long> {
  @Autowired
  private RoleMapper mapper;

  @Override
  protected GenericMapper<Role, Long> getGenericMapper() {
    return mapper;
  }

  public List<Role> selectUserRoles(Long userId) {
    return mapper.selectUserRoles(userId);
  }
}

