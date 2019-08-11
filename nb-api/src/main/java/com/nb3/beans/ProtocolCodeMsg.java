package com.nb3.beans;

/**
 * CopyRight (c)1999-2017 : zhcw.com
 * Project : data-analysis-center
 * Comments : 错误编码和错误消息
 * JDK version : JDK1.8
 * Create Date : 2017/4/1 17:37
 *
 * @author : Watson W
 * @version : 1.0
 * @since : 1.0
 */
public enum ProtocolCodeMsg {

  SERVER_BUSY("101301", "服务器繁忙"),
  JSON_PARS_ERROR("101302", "JSON解析错误"),
  SYS_TYPE_NOT_MATCH("101303", "系统类型不匹配"),
  MESSAGEID_NOT_ASSIGNED("101304", "messageID未赋值"),
  TIMESTAMP_NOT_ASSIGNED("101305", "timeStamp未赋值"),
  MESSENGERID_NOT_ASSIGNED("101306", "messengerID未赋值"),
  TRANSACTIONTYPE_NOT_ASSIGNED("101307", "transactionType未赋值"),
  SIGN_ERROR("101308", "签名失败"),
  TIMESTAMP_TIMEOUT("101309", "时间戳超时"),
  TOKEN_IS_NULL("101310", "sysType未赋值"),
  TT_NOT_ILLEGAL("101311", "协议号不合法"),
  TT_NOT_EXIST("101312", "协议号不存在"),
  REQUEST_TRANS_MESSAGE_NULL("101313", "请求参数为空"),
  MESSAGE_NULL("101314", "Message为空"),
  HEAD_NULL("101315", "Head为空"),
  PARAMETER_STRING_TO_OBJECT_FAILED("101316", "参数串转换对象失败"),
  REQUEST_USER_MESSAGE_ERROR("101317", "userId不合法"),
  ADDR_NOT_SIGN("101318", "校验未通过"),

  USER_NOT_EXIST("101319","用户不存在"),

  ID_IS_NULL("101320","id为空"),

  TOKEN_EXPIRED("101321","token已过期"),





  //订单查询 10130203


  //10130100 登录

  //10130201



  //10130114


  SUCCESS("000000", "成功"),
  FAIL("444444", "失败"),
  DATABASE_EXCEPTION("888888", "数据库异常");


  ProtocolCodeMsg(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  private final String code;

  private final String msg;

  public String getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
