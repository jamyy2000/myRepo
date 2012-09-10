package com.purang.bill.socket.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Company :普兰科技 Create User:周明 Create Date:12-8-16 Create Time:下午2:02
 */

// 大额往帐发送(汇兑)
public class Transfer extends BaseMessage implements Serializable {

    private static final long serialVersionUID = 2012346225783254278L;

    //private String tradeCode = "806055";
    // 发送标志(1 当日发送，3 隔日发送)
    private char flag;
    private Date primTranDate;                // 原交易日期
    private long sendSeqNo;                   // 往帐交易序号
    private double amount;                    // 交易金额

    public char getFlag() {
        return flag;
    }

    public void setFlag(char flag) {
        this.flag = flag;
    }

    public Date getPrimTranDate() {
        return primTranDate;
    }

    public void setPrimTranDate(Date primTranDate) {
        this.primTranDate = primTranDate;
    }

    public long getSendSeqNo() {
        return sendSeqNo;
    }

    public void setSendSeqNo(long sendSeqNo) {
        this.sendSeqNo = sendSeqNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}