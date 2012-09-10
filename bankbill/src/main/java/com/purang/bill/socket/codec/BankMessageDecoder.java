package com.purang.bill.socket.codec;

import com.purang.bill.socket.pojo.AbstrMessage;
import com.purang.bill.socket.pojo.BaseMessage;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * User: Zhou Ming Date: 12-8-15 Time: 下午12:54
 */
public class BankMessageDecoder implements MessageDecoder {

    public Logger logger = LoggerFactory.getLogger(BankMessageDecoder.class);

    Charset charset = Charset.forName("utf-8");

    private static String CONTEXT = BankMessageDecoder.class.getName() + ".context";

    @Override
    public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
        if (in.remaining() < BaseMessage.HEADER_SIZE) {
            return MessageDecoderResult.NEED_DATA;
        }
        try {
            String header = in.getString(BaseMessage.HEADER_SIZE, charset.newDecoder());
            String bodyNum = header.substring(8, 16);
            int num = new Integer(bodyNum).intValue();
            // String body = in.getString(charset.newDecoder());
            if (in.remaining() < num) {
                return MessageDecoderResult.NEED_DATA;
            }
        } catch (Exception e) {
            logger.error("客户端读取报文头错误：" + e);
            return MessageDecoderResult.NOT_OK;
        }
        return MessageDecoderResult.OK;
    }

    @Override
    public MessageDecoderResult decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        // Context ctx = getContext(session);
        CharsetDecoder decoder = charset.newDecoder();
        BaseMessage message = new BaseMessage() {
        };
        String header = in.getString(AbstrMessage.HEADER_SIZE, decoder);
        logger.info("读取报文头：" + header);
        String bodyNum = header.substring(8, 16);
        int num = new Integer(bodyNum).intValue();
        // todo
        String body = in.getString(num, decoder);
        logger.info("读取报文体：" + body);
        message.setHeader(header);
        message.setBody(body);
        out.write(message);
        return MessageDecoderResult.OK;
    }

    @Override
    public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
        logger.info("---decode 完毕---");
    }

    private Context getContext(IoSession session) {
        Context ctx = (Context) session.getAttribute(CONTEXT);
        if (ctx == null) {
            ctx = new Context();
            session.setAttribute(CONTEXT, ctx);
        }
        return ctx;
    }

    private class Context {
        private IoBuffer buffer;

        private Context() {
            buffer = IoBuffer.allocate(100).setAutoExpand(true);
        }

        public IoBuffer getBuffer() {
            return buffer;
        }
    }
}
