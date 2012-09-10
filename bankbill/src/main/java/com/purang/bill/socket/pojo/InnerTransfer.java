package com.purang.bill.socket.pojo;

import java.io.Serializable;

/**
 * Company :普兰科技 Create User:周明 Create Date:12-8-16 Create Time:下午3:11
 */

// 行内单笔转账
public class InnerTransfer extends BaseMessage implements Serializable {

	private static final long	serialVersionUID	= -5173041697851929673L;

	//public String				tradeCode			= "806011";
	/**
	 * 转出卡号/帐号
	 */
	public String				AcctNo;
	/**
	 * 转入卡号/帐号
	 */
	public String				AcctNo1;
	/**
	 * 转入账号姓名(有则校验，无不校验)
	 */
	public String				AcctName1;
	/**
	 * 转账金额
	 */
	public double				Amt1;
	/**
	 * 是否检查密码 ‘0’ – 不检查 ‘1’ – 检查密码
	 */
	public String				CheckFlag;
	/**
	 * 支取密码
	 */
	public String				Passwd;
	/**
	 * 手续费(0.00不收)
	 */
	public double				FeeAmt1;
	/**
	 * 手续费归属账号
	 */
	public String				FeeAcctNo1;

	/**
	 * 手续费付出账号(不填则手续费从转出账号中扣划)
	 */
	public String				FeeAcctNo2;
	/**
	 * 渠道
	 */
	public String				ChannelId;
	/**
	 * 网银流水号
	 */
	public String				BatchNo;
	/**
	 * 附言
	 */
	public String				MbfeMemo;
}