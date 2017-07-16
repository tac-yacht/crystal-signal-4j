package com.iyher.crystalsignal4j.api.ctrl;

import com.iyher.crystalsignal4j.Request;
import com.iyher.crystalsignal4j.api.ctrl.enums.Ack;

/**
 * 停止応答リクエスト
 * @author tac-yacht
 */
public class AckRequest implements Request {

	private static final String key = "ack";
	private static final AckRequest instance = new AckRequest();

	private final Ack ack;

	private AckRequest() {
		ack = Ack.YES;
	}

	public AckRequest(Ack ack) {
		this.ack = ack;
	}

	public static AckRequest getInstance() {
		return instance;
	}

	/** {@inheritDoc}*/
	@Override
	public String getQueryString() {
		return key + KV_SEPARATOR + ack.getValue();
	}

}
