package com.purang.bill.socket.codec;

import com.purang.bill.socket.pojo.BaseMessage;
import org.apache.mina.filter.codec.demux.DemuxingProtocolCodecFactory;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageEncoder;

/**
 * User: Zhou Ming Date: 12-8-15 Time: 下午8:42
 */
public class BankCodecFactory extends DemuxingProtocolCodecFactory {

	private MessageDecoder					decoder;
	private MessageEncoder<BaseMessage>	encoder;

	public BankCodecFactory(BankMessageDecoder messageDecoder, MessageEncoder<BaseMessage> messageEncoder) {
		this.decoder = messageDecoder;
		this.encoder = messageEncoder;
		addMessageDecoder(this.decoder);
		addMessageEncoder(BaseMessage.class, this.encoder);
	}
}
