package com.purang.bill.socket.pojo;

import java.io.Serializable;

/**
 * Company :普兰科技 Create User:周明 Create Date:12-8-16 Create Time:下午3:48
 */

// 小企业信贷多借多贷
public class BusinessLoan extends BaseMessage  implements Serializable {

	private static final long	serialVersionUID	= -745700850341483635L;

	//public String				tradeCode			= "806220";

	// 摘要码 (1041 代发工资，1006 代发，1007 代扣,1008 转账)默认为1008
	public String				MemoCode;
	// 批次号 8位日期+两位渠道编码+4位顺序号
	public String				BatchNo;
	// 是否校验户名 0不校验，1校验 默认为0
	public String				Flag;
	// 是否实时扣划 0实时，1非实时 默认为0
	public String				Flag0;
	// 手续费 默认为0.00 不收
	public double				FeeAmt1;
	// 手续费归属账号
	public String				FeeAcctNo1;
	// 手续费付出账号
	public String				FeeAcctNo2;
	// 文件名称
	public String				FileName;
	// MD5校验码
	public String				FILMD5;

}