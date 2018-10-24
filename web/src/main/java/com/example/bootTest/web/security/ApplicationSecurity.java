package com.example.bootTest.web.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

  @Value("${login.defaultSuccessUrl}")
  private String defaultSuccessUrl;

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/").setViewName("home.html");
    registry.addViewController("/home").setViewName("home.html");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/css/**").permitAll()
      .antMatchers("/user/**").hasRole("user")
      .antMatchers("/admin/**").hasRole("admin")
      .antMatchers("/test/**").access("hasRole('amdin') and hasRole('user')")
      .anyRequest()
      .fullyAuthenticated().and().formLogin().loginPage("/login").defaultSuccessUrl(defaultSuccessUrl)
       //.successForwardUrl("/afterLogin") forward到一个post service
      .failureUrl("/login?error").permitAll().and().logout().permitAll();
  }

  @Bean
  RoleHierarchy roleHierarchy() {
    RoleHierarchyImpl result = new RoleHierarchyImpl();
    result.setHierarchy("ROLE_admin > ROLE_user");
    return result;
  }
}
