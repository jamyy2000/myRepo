package com.purang.bill.socket.test;

import com.purang.bill.socket.codec.BankCodecFactory;
import com.purang.bill.socket.codec.BankMessageDecoder;
import com.purang.bill.socket.codec.BankMessageEncoder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LogLevel;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * User: Zhou Ming
 * Date: 12-8-15
 * Time: 下午8:57
 */
public class Server {
    public static Logger logger = LoggerFactory.getLogger(Server.class);

    private static int PORT = 3203;

    public static void main(String[] args) {
        logger.info("------------start socket server----------");
        try {
            BankCodecFactory codecFactory = new BankCodecFactory(new BankMessageDecoder(), new BankMessageEncoder());
            IoAcceptor acceptor = new NioSocketAcceptor();
            acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(codecFactory));
            LoggingFilter loggingFilter = new LoggingFilter();
            loggingFilter.setMessageReceivedLogLevel(LogLevel.DEBUG);
            acceptor.getFilterChain().addLast("logger", loggingFilter);

            IoSessionConfig sessionConfig = acceptor.getSessionConfig();
            sessionConfig.setIdleTime(IdleStatus.BOTH_IDLE, 100);
            acceptor.setHandler(new ServerHandle());
            acceptor.bind(new InetSocketAddress(PORT));
            logger.info("-------服务端启动成功...端口号为---" + PORT);
        } catch (IOException e) {
            logger.error("服务端启动异常....", e);
            e.printStackTrace();
        }
    }
}
