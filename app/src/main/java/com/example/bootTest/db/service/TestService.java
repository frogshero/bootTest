package com.example.bootTest.db;

import com.alibaba.fastjson.JSONObject;
import com.example.bootTest.db.dao.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

  @Autowired
  private AddressMapper addressMapper;

  public String getAddressJson(Long id) {
    return JSONObject.toJSONString(addressMapper.selectByPrimaryKey(id));
  }
}
