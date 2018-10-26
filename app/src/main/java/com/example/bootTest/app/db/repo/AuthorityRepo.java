package com.example.bootTest.app.db.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.bootTest.app.db.entity.Authority;
import com.example.bootTest.app.db.dao.AuthorityMapper;
import com.example.bootTest.common.mapper.GenericMapper;
import com.example.bootTest.common.mapper.GenericRepository;

@Repository
public class AuthorityRepo extends GenericRepository<Authority, Long> {
  @Autowired
  private AuthorityMapper mapper;

  @Override
  protected GenericMapper<Authority, Long> getGenericMapper() {
    return mapper;
  }
}

