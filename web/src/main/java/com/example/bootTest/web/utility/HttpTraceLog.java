package com.example.bootTest.web.utility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HttpTraceLog extends InMemoryHttpTraceRepository {

  @Override
  public void add(HttpTrace trace) {
    super.add(trace);
    String pattern = "{} {} Request: {} Response: {}";
    log.info(pattern, trace.getPrincipal() == null ? " " : trace.getPrincipal().getName(),
            trace.getTimeTaken().intValue(), trace.getRequest().getUri(),
            trace.getResponse().getStatus());
  }
}
