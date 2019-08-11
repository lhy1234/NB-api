package com.nb3.enums;

/**
 * Created by: 李浩洋 on 2019-07-25
 **/
public enum BlacklistEnum {


    OPEN(0,"黑白名单"),
    BLACKLIST(1,"黑名单"),
    WHITELIST(2,"白名单")

    ;

    private final int value;
    private final String text;

    BlacklistEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }}
