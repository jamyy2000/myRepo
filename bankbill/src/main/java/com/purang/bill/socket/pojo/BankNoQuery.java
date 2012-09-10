package com.purang.bill.socket.pojo;

import java.io.Serializable;

/**
 * Company :普兰科技 Create User:周明 Create Date:12-8-16 Create Time:下午3:42
 */

// 支付行名行号查询
public class BankNoQuery extends BaseMessage implements Serializable {

	private static final long	serialVersionUID	= 8514215783147873434L;

	//public String				tradeCode			= "535079";

	public String				MsgCont1;									// 城市名称

}