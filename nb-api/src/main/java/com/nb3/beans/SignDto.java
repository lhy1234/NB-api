package com.nb3.beans;

import java.util.Map;

public class SignDto {

    private String secret;

    private String token;

    private String transactionType;

    private String timestamp;

    private Map reqBody;



    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Map getReqBody() {
        return reqBody;
    }

    public void setReqBody(Map reqBody) {
        this.reqBody = reqBody;
    }
}
