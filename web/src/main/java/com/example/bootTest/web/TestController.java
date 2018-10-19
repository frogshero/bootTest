package com.example.bootTest.web;

import com.example.bootTest.app.db.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @Autowired
  private TestService testService;

  @GetMapping("/test/{id}")
  public String getInfo(@PathVariable Long id) {
    return testService.getAddressJson(id);
  }
}
