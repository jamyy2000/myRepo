package com.purang.bill.socket.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Company :普兰科技 Create User:周明 Create Date:12-8-16 Create Time:下午2:37
 */

// 大额往帐查询(汇兑)
public class TransferQuery extends BaseMessage implements Serializable {

	private static final long	serialVersionUID	= -7205811814389669573L;

	//public String				tradeCode			= "806054";
	/**
	 * 发送标志(1 当日发送，3 隔日发送)
	 */
	public char					flag;
	/**
	 * 原交易日期
	 */
	public Date					primTranDate;
	/**
	 * 往帐交易序号
	 */
	public long					sendSeqNo;
	/**
	 * 交易金额(可不赋值)
	 */
	public double				amount;
	/**
	 * 业务状态(默认赋值为0) 0 通查 1 已登记 2 已复核 3 已发送 4 发送失败 5 滞留 6 已清算 7 排队 8 排队取消
	 */
	public char					status;

}