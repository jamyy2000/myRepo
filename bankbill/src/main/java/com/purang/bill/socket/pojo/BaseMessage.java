package com.purang.bill.socket.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * User: Zhou Ming Date: 12-8-15 Time: 上午9:52
 */
public abstract class BaseMessage extends AbstrMessage implements Serializable {

	private static final long	serialVersionUID	= 7100662021086234081L;

	// 授权柜员
	protected String			aTeller;
	// 授权柜员密码
	protected String			aTelPasswd;
	// 授权码
	protected String			authCode;
	// 授权标志(默认填0)
	protected String			authFlag;
	// 授权信息
	protected String			authMsg;
	// 授权执行动作
	protected String			authWork;
	// 机构码
	protected String			brc;
	// 公共交易机构名称
	protected String			brcName0;
	// 交易柜员
	protected String			teller;
	// 操作员级别
	protected String			tellerLvl0;
	// 柜员名称
	protected String			tellerName;
	// 操作员种类
	protected String			tellerType0;
	// 柜员密码
	protected String			telPasswd;
	// 终端号
	protected String			termId;
	// 终端IP地址
	protected String			termIP;
	// 交易日期(YYYY-MM-DD)
	protected Date				tranDate;
	// 公共交易名称
	protected String			tranName;
	// 交易来源(渠道代码,和报文头保持一致) 17 网上银行,18 手机银行,20呼叫中心
	protected String			channelId;

    public BaseMessage() {
    }

    public String getaTeller() {
		return aTeller;
	}

	public void setaTeller(String aTeller) {
		this.aTeller = aTeller;
	}

	public String getaTelPasswd() {
		return aTelPasswd;
	}

	public void setaTelPasswd(String aTelPasswd) {
		this.aTelPasswd = aTelPasswd;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getAuthFlag() {
		return authFlag;
	}

	public void setAuthFlag(String authFlag) {
		this.authFlag = authFlag;
	}

	public String getAuthMsg() {
		return authMsg;
	}

	public void setAuthMsg(String authMsg) {
		this.authMsg = authMsg;
	}

	public String getAuthWork() {
		return authWork;
	}

	public void setAuthWork(String authWork) {
		this.authWork = authWork;
	}

	public String getBrc() {
		return brc;
	}

	public void setBrc(String brc) {
		this.brc = brc;
	}

	public String getBrcName0() {
		return brcName0;
	}

	public void setBrcName0(String brcName0) {
		this.brcName0 = brcName0;
	}

	public String getTeller() {
		return teller;
	}

	public void setTeller(String teller) {
		this.teller = teller;
	}

	public String getTellerLvl0() {
		return tellerLvl0;
	}

	public void setTellerLvl0(String tellerLvl0) {
		this.tellerLvl0 = tellerLvl0;
	}

	public String getTellerName() {
		return tellerName;
	}

	public void setTellerName(String tellerName) {
		this.tellerName = tellerName;
	}

	public String getTellerType0() {
		return tellerType0;
	}

	public void setTellerType0(String tellerType0) {
		this.tellerType0 = tellerType0;
	}

	public String getTelPasswd() {
		return telPasswd;
	}

	public void setTelPasswd(String telPasswd) {
		this.telPasswd = telPasswd;
	}

	public String getTermId() {
		return termId;
	}

	public void setTermId(String termId) {
		this.termId = termId;
	}

	public String getTermIP() {
		return termIP;
	}

	public void setTermIP(String termIP) {
		this.termIP = termIP;
	}

	public Date getTranDate() {
		return tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public String getTranName() {
		return tranName;
	}

	public void setTranName(String tranName) {
		this.tranName = tranName;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
}
