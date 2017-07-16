package com.iyher.crystalsignal4j.api.ctrl.enums;

public enum Ack {
	/** 発生*/ NO(0),
	/** 停止*/ YES(1),
	;

	private int value;
	private Ack(int value) {
		this.value = value;
	}

	/**
	 * 送信に用いる値
	 * @return 値
	 */
	public int getValue() {
		return value;
	}

}
