package com.purang.bill.socket.pojo;

/**
 * User: Zhou Ming
 * Date: 12-8-15
 * Time: 下午2:51
 */
public abstract class MessageHeader {

    /**
     * 上送报文头：
     * 00000372 00000314 21B040 RQ 17 0000001 XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX 3
     */
    public String allLength;  //8位  整个报文但不包括前8位的长度

    public String bodyLength;  //8位 报文中KeyValue报文的长度

    public String tradeCode;  //6位 交易码

    public String dateType;  //2位 RQ:请求报文 RS:返回报文

    public String channel;  //2位 代表渠道

    public String fixedCode;  //7位 固定0000001

    public String md5Code;  //32位 固定0000001  KeyValue部分的md5的16进制结果

    public String commuType;  //1位  固定(3 TCP方式,1 CICS)

    public String getAllLength() {
        return allLength;
    }

    public void setAllLength(String allLength) {
        this.allLength = allLength;
    }

    public String getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getFixedCode() {
        return fixedCode;
    }

    public void setFixedCode(String fixedCode) {
        this.fixedCode = fixedCode;
    }

    public String getMd5Code() {
        return md5Code;
    }

    public void setMd5Code(String md5Code) {
        this.md5Code = md5Code;
    }

    public String getCommuType() {
        return commuType;
    }

    public void setCommuType(String commuType) {
        this.commuType = commuType;
    }
}
