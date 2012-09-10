package com.purang.bill.socket.pojo;

import java.io.Serializable;

/**
 * Company :普兰科技 Create User:周明 Create Date:12-8-16 Create Time:下午3:44
 */

// 支付行名行号查询 返回的文件内容
public class BankNoQueryResponse implements Serializable {

	private static final long	serialVersionUID	= 4207763963184617470L;

	public String				ElecBankNo;									// 电联行号
	public String				CnapsBankNo;								// 支付系统行号
	public String				BankType;									// 类型
	public String				BankName;									// 行名
	public String				DpBankNo;									// 清算行号
	public String				CCPCNo;										// 中心代码
	public String				BankTel;									// 联系电话
	public String				BankPer;									// 联系人
	public String				BankAddr;									// 联系地址
	public String				BnkssName;									// 小站名称

}