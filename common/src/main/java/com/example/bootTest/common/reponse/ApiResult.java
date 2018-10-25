package com.example.bootTest.common.reponse;

import com.example.bootTest.common.exception.ErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@ApiModel
public class ApiResult<T> {
  @ApiModelProperty(value="返回码",required=true)
  private String code;

  @ApiModelProperty(value="返回数据内容",required=true)
  private T data;

  @ApiModelProperty(value="返回消息",required=true)
  private String message;

  //if there is no default constructor, deserialization is failed.
  public ApiResult() {
  }

  public ApiResult(ErrorCode errorCode) {
    this(ErrorCode.OK, null);
  }

  public ApiResult(ErrorCode errorCode, String retMsg, T data) {
    this.code = errorCode.getCode();
    this.message = retMsg;
    this.data = data;
  }

  public ApiResult(ErrorCode errorCode, T data) {
    this(errorCode, errorCode.getDesc(), data);
  }

  public ApiResult(T data) {
    this(ErrorCode.OK, data);
  }
}
