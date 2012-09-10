package com.purang.bill.socket.pojo;

import java.io.Serializable;

/**
 * Company :普兰科技
 * Create User:周明
 * Create Date:12-8-16
 * Create Time:下午1:41
 */

//大额往帐登记(汇兑 跨行转账)
public class TransferRegister extends BaseMessage implements Serializable {

	private static final long	serialVersionUID	= 4933635346088382455L;

	//private String tradeCode = "806053";//交易代码

    private String payAccNo;    //付(汇)款人帐号
    private String payAccName;  // 付款人姓名
    private String recvAccNo;    // 收款人账号
    private String recvAccName;  // 收款人户名
    private String recvBankNo;    // 接收行行号
    private String recvBankName;  // 收款行名称
    private String customType;      // 帐户类型(1 储蓄，2对公，3同业)
    private String ccy;             // 币种
    private String mbfeMemo;     // 往帐附言
    private String flag;         // 是否校验密码(0 不校验，1 校验)
    private String passwd;         // 密码
    private double amount;         // 交易金额
    private String cTFlag;         // 现转标志(设置为2，代表转账)
    private String msgAttr;         // 优先级(0 普通,1 紧急,2 特急,)
    private String teller2;         // 发送柜员
    private String batchNo;         // 网银流水号

    public String getPayAccNo() {
        return payAccNo;
    }

    public void setPayAccNo(String payAccNo) {
        this.payAccNo = payAccNo;
    }

    public String getPayAccName() {
        return payAccName;
    }

    public void setPayAccName(String payAccName) {
        this.payAccName = payAccName;
    }

    public String getRecvAccNo() {
        return recvAccNo;
    }

    public void setRecvAccNo(String recvAccNo) {
        this.recvAccNo = recvAccNo;
    }

    public String getRecvAccName() {
        return recvAccName;
    }

    public void setRecvAccName(String recvAccName) {
        this.recvAccName = recvAccName;
    }

    public String getRecvBankNo() {
        return recvBankNo;
    }

    public void setRecvBankNo(String recvBankNo) {
        this.recvBankNo = recvBankNo;
    }

    public String getRecvBankName() {
        return recvBankName;
    }

    public void setRecvBankName(String recvBankName) {
        this.recvBankName = recvBankName;
    }

    public String getCustomType() {
        return customType;
    }

    public void setCustomType(String customType) {
        this.customType = customType;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getMbfeMemo() {
        return mbfeMemo;
    }

    public void setMbfeMemo(String mbfeMemo) {
        this.mbfeMemo = mbfeMemo;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getcTFlag() {
        return cTFlag;
    }

    public void setcTFlag(String cTFlag) {
        this.cTFlag = cTFlag;
    }

    public String getMsgAttr() {
        return msgAttr;
    }

    public void setMsgAttr(String msgAttr) {
        this.msgAttr = msgAttr;
    }

    public String getTeller2() {
        return teller2;
    }

    public void setTeller2(String teller2) {
        this.teller2 = teller2;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
}