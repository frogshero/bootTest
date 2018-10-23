package com.example.bootTest.app.db.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.bootTest.app.db.entity.TestOrganization;
import com.example.bootTest.app.db.dao.TestOrganizationMapper;
import com.example.bootTest.app.db.generic.GenericMapper;
import com.example.bootTest.app.db.generic.GenericRepository;

@Repository
public class TestOrganizationRepo extends GenericRepository<TestOrganization, Long> {
  @Autowired
  private TestOrganizationMapper mapper;
  
  @Override
  protected GenericMapper<TestOrganization, Long> getGenericMapper() {
    return mapper;
  }
}

