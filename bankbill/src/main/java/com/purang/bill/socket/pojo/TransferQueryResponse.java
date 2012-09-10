package com.purang.bill.socket.pojo;

import java.io.Serializable;

/**
 * Company :普兰科技
 * Create User:周明
 * Create Date:12-8-16
 * Create Time:下午2:52
 */

//大额往帐查询(汇兑) 返回 的文件内容
public class TransferQueryResponse implements Serializable {

	private static final long	serialVersionUID	= 6484506160994809327L;
	public String TranDate;          //交易日期
    public String SendSeqNo;       //往帐交易序号
    public String ODFICode;       //发起行行号
    public String RecvBankNo;       //接收行行号
    public String CnapsNo;       //发起清算行号
    public String RecvCnapsNo;       //接收清算行号
    public String Brc;             //机构码
    public String Amount;          //金额
    public String SerSeqNo;       //登记流水号
    public String SerSeqNo1;       //复核流水号
    public String SerSeqNo2;       //发送流水号
    public String BusiKind;       //业务种类<0>汇兑<1>委托收款<2>托收承付<3>国库资金汇划<5>银行间拆借<6>商业银行汇票<8>退汇<9>电子联行
    public String BillType;       //委托票据类别 <01>银行承兑汇票<02>定期存单<03>凭证式国债<04>异地活期存折<05>商业承兑汇票<08>商业银行汇票<99>其他
    public String BusiList;       //业务明细11_普通汇兑
    public String TranSysTime;       //系统本地交易时间
    public String SendMsgDate;       //发报日期
    public String RecvMsgDate;       //收报日期
    public String ClearDate;       //清算日期
    public String CmtVouDate;       //委托凭证日期
    public String PayBankNo;       //付款人开户行
    public String PayAccNo;       //付款人帐号
    public String PayAddress;       //付款人地址
    public String PayAccName;       //付款人户名
    public String RecvOpenBankNo;       //收款人开户行号
    public String RecvAccNo;       //收款人帐号
    public String RecvAddress;       //收款人地址
    public String RecvAccName;       //收款人户名
    public String VouKind;       //帐户凭证种类
    public String BillStan;       //委收托收交易序号
    public String BillNo;       //委收托收凭证号码
    public String SecretNo;       //密押
    public String AmendsAmt;       //托收赔偿金额
    public String RefuseAmount;       //托收拒付金额
    public String Rate;       //拆借利率
    public String BorrowTerm;       //拆借期限
    public String RecvSeqNo;       //来帐交易序号
    public String SendCCPCNo;       //发报中心代码
    public String RecvCCPCNo;       //收报中心代码
    public String Teller;       //记帐员编号
    public String RTeller;       //复核员编号
    public String STeller;       //发送员编号
    public String Memo;             //附言
    public String PrintNum;       //打印次数
    public String TranKind;       //交易种类 <0>大额 <1>小额 <2>其它
    public String Status;       //业务状态 <1>已登记<2>已复核<3>已发送<4>发送失败<5>滞留<6>已清算<7>排队<8>排队取消<9>人行拒绝排队撤销<r>人行拒绝<k>密押错<m>抹帐<h>挂失<j>解挂
    public String MsgAttr;       //报文类型 <0>普通 <1>急 <2>特急
    public String CheckFlag;       //对帐标志 <0>未对帐<1>对帐正确<2>对帐失败
    public String AppIdType;       //付款人证件类型
    public String AppIdNo;       //付款人证件号码

}