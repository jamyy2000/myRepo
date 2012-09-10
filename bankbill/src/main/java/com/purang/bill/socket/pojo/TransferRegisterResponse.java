package com.purang.bill.socket.pojo;

import java.io.Serializable;

/**
 * Company :普兰科技
 * Create User:周明
 * Create Date:12-8-16
 * Create Time:下午1:56
 */

//大额往帐登记返回
public class TransferRegisterResponse implements Serializable {

	private static final long	serialVersionUID	= -4520154742178955041L;
	private long serSeqNo;       //主机流水号
    private long sendSeqNo;       //往帐交易序号
    private double bal;             //余额
    private String brc1;            //开户机构
    private String brc2;            //核算机构
    private String brcPhone;       //机构电话
    private String brcName1;       //开户机构名称
    private String brcName2;       //核算机构名称

    public long getSerSeqNo() {
        return serSeqNo;
    }

    public void setSerSeqNo(long serSeqNo) {
        this.serSeqNo = serSeqNo;
    }

    public long getSendSeqNo() {
        return sendSeqNo;
    }

    public void setSendSeqNo(long sendSeqNo) {
        this.sendSeqNo = sendSeqNo;
    }

    public double getBal() {
        return bal;
    }

    public void setBal(double bal) {
        this.bal = bal;
    }

    public String getBrc1() {
        return brc1;
    }

    public void setBrc1(String brc1) {
        this.brc1 = brc1;
    }

    public String getBrc2() {
        return brc2;
    }

    public void setBrc2(String brc2) {
        this.brc2 = brc2;
    }

    public String getBrcPhone() {
        return brcPhone;
    }

    public void setBrcPhone(String brcPhone) {
        this.brcPhone = brcPhone;
    }

    public String getBrcName1() {
        return brcName1;
    }

    public void setBrcName1(String brcName1) {
        this.brcName1 = brcName1;
    }

    public String getBrcName2() {
        return brcName2;
    }

    public void setBrcName2(String brcName2) {
        this.brcName2 = brcName2;
    }
}