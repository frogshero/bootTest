package com.example.bootTest.app.db.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.bootTest.app.db.entity.Organization;
import com.example.bootTest.app.db.dao.OrganizationMapper;
import com.example.bootTest.common.mapper.GenericMapper;
import com.example.bootTest.common.mapper.GenericRepository;

@Repository
public class OrganizationRepo extends GenericRepository<Organization, Long> {
  @Autowired
  private OrganizationMapper mapper;

  @Override
  protected GenericMapper<Organization, Long> getGenericMapper() {
    return mapper;
  }
}

