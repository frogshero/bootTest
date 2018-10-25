package com.example.bootTest.common.exception;

public enum ErrorCode {
  // 20000
  OK("0000", "OK"),
  HTTP_INTERNAL_ERR("500", "Internal Error"),

  SESSION_TIMEOUT("302", "Session Timeout"),

  // 30000: rule verification error
  RULE_PARSE_ERROR("3003", "Rule Parsing Error"),
  //
  COMMON_VALIDATION_FAIL("3004", "Validation fail"),
  //
  PARAM_MISS("3005", "Required Parameter is missing"),
  //
  MONTH_QUOTA_FAIL("3006","month quota fail"),
  //
  DATE_QUOTA_FAIL("3007","date quota fail"),

  // 4000
  COMMON_ERROR("4000", "Request fail"),
  //
  INVALID_PARAMETER("4001", "Invalid Parameter"),
  //
  INVALID_OPERATION("4002", "Invalid Operation"),
  //
  FORBIDDEN("4003", "Auth failed"),
  //
  NOT_FOUND("4004", "Data not found"),
  //
  LOSE_EFFICACY("4005", "Data lose effectiveness"),
  //
  TIME_OUT("4006", "Request time out"),
  //
  CLIENT_EXP("4007", "client invoke fail"),
  //
  DATA_EXISTED("4008", "Data existed"),

  // 5000
  INTERNAL_ERROR("5000", "Internal Error"),

  INVALID_PRO_CODE("5000", "Invalid proCode"),

  USER_ID_PRO_CODE_NOT_MATCH("5000", "User id and procode not match"),

  INVALID_SIGN("5001", "Invalid Sign")
  ;

  private String code;
  private String desc;

  ErrorCode(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String getCode() {
    return code;
  }


  public String getDesc() {
    return desc;
  }


  public static boolean isOk(String code) {
    return code.equals(OK.getCode());
  }
}
