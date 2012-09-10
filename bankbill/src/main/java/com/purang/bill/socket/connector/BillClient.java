package com.purang.bill.socket.connector;

import com.purang.bill.socket.codec.BankCodecFactory;
import com.purang.bill.socket.codec.BankMessageDecoder;
import com.purang.bill.socket.codec.BankMessageEncoder;
import com.purang.bill.socket.pojo.AbstrMessage;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * User: Zhou Ming Date: 12-8-15 Time: 上午11:43
 */
public class BillClient {
	private Logger	logger	= LoggerFactory.getLogger(BillClient.class);

	public void sendData(String host, int port, AbstrMessage message) {
		logger.info("---客户端发送数据--" + message);
		IoConnector connector = new NioSocketConnector();
		connector.setConnectTimeoutMillis(60 * 1000L);
		connector.getFilterChain().addLast("logger", new LoggingFilter());

		BankCodecFactory codecFactory = new BankCodecFactory(new BankMessageDecoder(), new BankMessageEncoder());
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(codecFactory));
		connector.setHandler(new BankBillClientHandle());
		IoSession session = null;
		try {
			ConnectFuture future = connector.connect(new InetSocketAddress(host, port));
			future.awaitUninterruptibly();// 等待连接创建完成
			session = future.getSession();

			session.write(message);
		} catch (Exception e) {
			logger.error("客户端连接异常......", e);
		}
		session.getCloseFuture().awaitUninterruptibly();
		connector.dispose();
	}
}
