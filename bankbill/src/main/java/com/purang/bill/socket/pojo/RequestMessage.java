package com.purang.bill.socket.pojo;

/**
 * Company :普兰科技
 * Create User:周明
 * Create Date:12-8-16
 * Create Time:上午11:51
 */

//请求报文
public class RequestMessage extends BaseMessage {

    private static final long serialVersionUID = 2445251445948692195L;

    private MessageHeader header;

    private String body;

    public RequestMessage() {
    }

    public RequestMessage(MessageHeader header, String body) {
        this.header = header;
        this.body = body;
    }
}
