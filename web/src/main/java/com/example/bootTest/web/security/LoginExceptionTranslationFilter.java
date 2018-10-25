package com.example.bootTest.web.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.savedrequest.RequestCache;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class LoginExceptionTranslationFilter extends ExceptionTranslationFilter {
  private static final String AJAX_HEADER = "X-Requested-With";
  private static final String JQUERY_XMLHttpRequest_HEADER = "XMLHttpRequest";
  private static final String CROSS_RESOURCE_ORIGIN_HEADER = "Origin";

  public LoginExceptionTranslationFilter(AuthenticationEntryPoint authenticationEntryPoint, RequestCache requestCache) {
    super(authenticationEntryPoint, requestCache);
  }

  public LoginExceptionTranslationFilter(AuthenticationEntryPoint authenticationEntryPoint) {
    super(authenticationEntryPoint);
  }

  public static Boolean isAjaxRequest(HttpServletRequest httpServletRequest) {
    if (httpServletRequest == null) {
      return Boolean.FALSE;
    }
    String ajaxValue = httpServletRequest.getHeader(AJAX_HEADER);
    if (JQUERY_XMLHttpRequest_HEADER.equalsIgnoreCase(ajaxValue)) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }

  public static Boolean isCORSRequest(HttpServletRequest httpServletRequest) {
    if (httpServletRequest == null) {
      return Boolean.FALSE;
    }

    String originValue = httpServletRequest.getHeader(CROSS_RESOURCE_ORIGIN_HEADER);

    if (originValue == null) {
      return Boolean.FALSE;
    } else {
      String baseUrl = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort();
      String baseUrlStr = baseUrl.replaceAll("https|http", "");
      String ajaxCrossStr = originValue.replaceAll("https|http", "");
      if (baseUrlStr.startsWith(ajaxCrossStr)) {
        return Boolean.FALSE;
      } else {
        return Boolean.TRUE;
      }
    }
  }

  @Override
  protected void sendStartAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, AuthenticationException reason) throws ServletException, IOException {
    SecurityContextHolder.getContext().setAuthentication(null);
    if (isAjaxRequest(request) || isCORSRequest(request)) {
      log.debug("This ia an ajax or cors request, return json to client side.");

      String loginUrl = request.getScheme() + request.getHeader("host") + "/login";
      response.setContentType("application/json");
      response.addHeader("Cache-Control", "no-store");
      response.setStatus(200);
      response.getWriter().println("{");
      response.getWriter().println("\"info\":");
      response.getWriter().println("[");
      response.getWriter().println("{");
      response.getWriter().println("\"name\": \"AppConstants.LOGIN_REDIRECT_URL\",");
      response.getWriter().println("\"msg\": \"" + loginUrl + "\"");
      response.getWriter().println("}");
      response.getWriter().println("]");
      response.getWriter().println("}");
    } else {
      super.sendStartAuthentication(request, response, chain, reason);
    }
  }
}
