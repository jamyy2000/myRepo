package com.purang.bill.socket.pojo;

/**
 * User: Zhou Ming
 * Date: 12-8-15
 * Time: 下午2:51
 */
public abstract class AbstrMessage {

    public static int HEADER_SIZE = 66;
    private String header;
    private String body;
    private String tradeCode;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }
}
