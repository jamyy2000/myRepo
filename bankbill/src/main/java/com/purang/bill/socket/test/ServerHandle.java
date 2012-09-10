package com.purang.bill.socket.test;

import com.purang.bill.socket.pojo.AbstrMessage;
import com.purang.bill.socket.pojo.Transfer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * User: Zhou Ming
 * Date: 12-8-15
 * Time: 下午9:10
 */
public class ServerHandle extends IoHandlerAdapter {
    public static Logger logger = LoggerFactory.getLogger(ServerHandle.class);

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        logger.info("客户端断开连接...");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        logger.info("服务端与客户端连接打开...");
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        AbstrMessage msg = (AbstrMessage) message;
        logger.info("服务器发送数据---" + msg);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        AbstrMessage msg = (AbstrMessage) message;
        logger.info("----服务器接收到的数据---\n" + msg);

        Transfer t = new Transfer();
        t.setTradeCode("AAAAAA");
        t.setChannelId("17");
        t.setFlag('1');
        t.setAmount(999.99);
        t.setPrimTranDate(new Date());
        t.setSendSeqNo(98765421);
        session.write(t);
    }
}
