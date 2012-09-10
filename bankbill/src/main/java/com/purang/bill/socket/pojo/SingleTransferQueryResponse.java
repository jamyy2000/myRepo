package com.purang.bill.socket.pojo;

import java.io.Serializable;

/**
 * Company :普兰科技 Create User:周明 Create Date:12-8-16 Create Time:下午3:27
 */

// 单笔转账查询 返回
public class SingleTransferQueryResponse implements Serializable {

	private static final long	serialVersionUID	= 4509202022858630036L;
	public long					SendSeqNo;									// 往帐交易序号
	public long					SerSeqNo2;									// 主机交易流水号
	public String				Flag0;										// 标志(行内2表示成功，跨行为状态位)

}