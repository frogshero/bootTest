package com.example.bootTest.web.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static javafx.scene.input.KeyCode.T;

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
      .anyRequest().fullyAuthenticated()
      .and().formLogin().loginPage("/login").defaultSuccessUrl(defaultSuccessUrl)
      .failureUrl("/login?error").permitAll()
      .and().cors()
      .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")).permitAll().logoutSuccessUrl("/login").deleteCookies("JSESSIONID")
      //处理ajax调用访问异常。不跳转到登录页面，由前端处理
//      .and().exceptionHandling().withObjectPostProcessor(new ObjectPostProcessor<ExceptionTranslationFilter>(){
//      @Override
//      public <O extends ExceptionTranslationFilter> O postProcess(O object) {
//        ExceptionTranslationFilter newFilter = new LoginExceptionTranslationFilter(object.getAuthenticationEntryPoint(), http.getSharedObject(RequestCache.class));
//        //newFilter.setAccessDeniedHandler(); ??
//        return (O)newFilter;
//      }})
    ;
  }

  @Bean
  public RoleHierarchy roleHierarchy() {
    RoleHierarchyImpl result = new RoleHierarchyImpl();
    result.setHierarchy("ROLE_admin > ROLE_user");
    return result;
  }

}
