package com.ehsancode.demo.helper;

public class AppResponse {
  private int statusCode;
  private String msg;
  private Object body;

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getBody() {
    return body;
  }

  public void setBody(Object body) {
    this.body = body;
  }

  public AppResponse(int statusCode, String msg, Object body) {
    this.statusCode = statusCode;
    this.msg = msg;
    this.body = body;
  }
}
