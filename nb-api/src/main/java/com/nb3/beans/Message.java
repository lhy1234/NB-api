package com.nb3.beans;

import java.util.Map;

/**
 * Created by: 李浩洋 on 2019-07-24
 **/
public class Message {

    private HeadBean head;

    private Map<String , Object> body;

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
}
