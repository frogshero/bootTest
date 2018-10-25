package com.example.bootTest.web.utility;


import com.example.bootTest.common.exception.ErrorCode;
import com.example.bootTest.common.exception.TestAppException;
import com.example.bootTest.common.reponse.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

@ControllerAdvice
public class TestExceptionHandler {

  private Logger logger = LoggerFactory.getLogger(TestExceptionHandler.class);

  @ResponseBody
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ApiResult handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    logger.error("Exception", ex);
    StringBuilder sb = new StringBuilder("");
    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      sb.append("[");
      if (error instanceof FieldError) {
        sb.append(((FieldError)error).getField()).append(":").append(error.getDefaultMessage());
      } else {
        sb.append(error);
      }
      sb.append("] ");
    }
    return new ApiResult(ErrorCode.HTTP_INTERNAL_ERR, sb.toString());
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  @ExceptionHandler(Exception.class)
  public ApiResult handleException(Exception ex) {
    logger.error("Exception", ex);
    String msg = "";
    //数据异常不需要返回详细信息
    if (ex instanceof DataAccessException || ex instanceof SQLException) {
      msg += "Data Exception";
    } else {
      msg += ex.getMessage();
    }
    return new ApiResult(ErrorCode.HTTP_INTERNAL_ERR, msg);
  }

  @ResponseBody
  @ExceptionHandler(TestAppException.class)
  public ApiResult handleTestAppException(TestAppException ex) {
    logger.error("TestAppException", ex);
    return new ApiResult(ErrorCode.HTTP_INTERNAL_ERR);
  }
}
