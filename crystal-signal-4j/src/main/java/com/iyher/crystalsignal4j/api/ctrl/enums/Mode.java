package com.iyher.crystalsignal4j.api.ctrl.enums;

public enum Mode {
	/** 点灯*/ ON(0),
	/** 点滅*/ BLINKING(1),
	/** 非同期点滅*/ BLINKING_ASYNCHRONOUSLY(2),
	;

	private int value;
	private Mode(int value) {
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
