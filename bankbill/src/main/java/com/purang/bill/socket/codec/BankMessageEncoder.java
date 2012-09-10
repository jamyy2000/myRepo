package com.purang.bill.socket.codec;

import com.purang.bill.socket.pojo.BaseMessage;
import com.purang.bill.socket.xml.MessageUtil;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.demux.MessageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * User: Zhou Ming Date: 12-8-15 Time: 下午12:54
 */
public class BankMessageEncoder implements MessageEncoder<BaseMessage> {

    public Logger logger = LoggerFactory.getLogger(BankMessageEncoder.class);

    Charset charset = Charset.forName("utf-8");

    @Override
    public void encode(IoSession session, BaseMessage message, ProtocolEncoderOutput out) throws Exception {
        IoBuffer buf = IoBuffer.allocate(100).setAutoExpand(true);
        String header = MessageUtil.generateSendMessageHeader(message);
        buf.putString(header, charset.newEncoder());
        String body = MessageUtil.generateSendMessageBody(message);
        buf.putString(body, charset.newEncoder());

        buf.flip();
        logger.info("---encode编码---" + buf.toString());
        out.write(buf);
    }
}
