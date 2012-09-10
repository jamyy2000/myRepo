package com.purang.bill.socket.connector;

import com.purang.bill.socket.pojo.AbstrMessage;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: Zhou Ming Date: 12-8-15 Time: 下午12:37
 */
public class BankBillClientHandle extends IoHandlerAdapter {

	private Logger	logger	= LoggerFactory.getLogger(BankBillClientHandle.class);

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		logger.info("Session opened");
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		logger.info("session closed");
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		logger.error("客户端发生异常...", cause);
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		IoBuffer buf = IoBuffer.allocate(1024, false).setAutoExpand(true);
		AbstrMessage msg = (AbstrMessage) message;
		logger.info("客户端接收到的消息 tradeCode：\n" + msg.getBody());

        session.close(true);
		// session.write(buf);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		AbstrMessage msg = (AbstrMessage) message;
		logger.info("session 发送数据 tradeCode：\n" + msg.getTradeCode());
	}
}
