package com.purang.bill.socket.test;


import com.purang.bill.socket.connector.BillClient;
import com.purang.bill.socket.pojo.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class Client {
    public static Logger logger = LoggerFactory.getLogger(Client.class);

    private static String HOST = "127.0.0.1";
    private static int PORT = 3203;

    public static void main(String[] args) {
        //String header = "000003720000031421B040RQ170000001XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX3";
        //String body = "<TranDate>2008-03-24</><AuthFlag>0</><BrcName0>哈尔滨市商业银行大庆路支行</><TellerLvl0>13</><TelPasswd>0a2a488cbddb837b</><TellerType0>03</><ChannelId>12</><Teller>2601</><Brc>2601</><TranName>现金存款/取款</><TermIP>168.1.1.123</><TellerName>石可升</><TermId>ttyp6</><AcctNo1>1</><AcctSeqNo1>1</><SubAcct1>DPS</>";
        Transfer t = new Transfer();
        t.setTradeCode("200012");
        t.setChannelId("17");
        t.setFlag('1');
        t.setAmount(888.88);
        t.setPrimTranDate(new Date());
        t.setSendSeqNo(123456);
        BillClient client = new BillClient();
        client.sendData(HOST, PORT, t);
        logger.info("---客户端发送数据完成--");
    }
}
