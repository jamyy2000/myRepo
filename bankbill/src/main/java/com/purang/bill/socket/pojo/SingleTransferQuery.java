package com.purang.bill.socket.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Company :普兰科技 Create User:周明 Create Date:12-8-16 Create Time:下午3:24
 */

// 单笔转账查询
public class SingleTransferQuery extends BaseMessage implements Serializable {

	private static final long	serialVersionUID	= 12461599371920318L;

	//public String				tradeCode			= "806057";

	/**
	 * 原交易日期
	 */
	public Date					PrimTranDate;
	/**
	 * 帐号
	 */
	public String				AcctNo;
	/**
	 * 网银流水号
	 */
	public String				BatchNo;
	/**
	 * 跨行标志(0行内，1跨行)
	 */
	public char					Flag;

}