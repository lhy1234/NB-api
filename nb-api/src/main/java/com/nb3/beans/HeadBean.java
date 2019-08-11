package com.nb3.beans;

/**
 * Created by: 李浩洋 on 2019-07-24
 **/
public class HeadBean {

    /**
     * 交易效验类型
     */
    private String transactionType;

    /**
     * 处理状态
     */
    private String resCode;

    /**
     * 处理消息
     */
    private String message;

    /**
     * token
     */
    private String token;
    /**
     * 时间戳
     */
    private String timestamp;
    /**
     * 对消息包的摘要, 摘要算法为MD5+base64，摘要的内容为
     * 先对内容进行base64编码,再对内容进行MD5加密
     * （messageID+timeStamp+messengerID+platform+transactionType+密码+消息体） 密码=weichat@$^000101
     */
    private String sign;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
