package com.purang.bill.socket.pojo;

import java.io.Serializable;

/**
 * Company :普兰科技 Create User:周明 Create Date:12-8-16 Create Time:下午3:21
 */

// 行内单笔转账 返回
public class InnerTransferResponse implements Serializable {

	private static final long	serialVersionUID	= 3419823047485467282L;
	/**
	 * 主机流水号
	 */
	public String				SerSeqNo;
}