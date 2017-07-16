package com.iyher.crystalsignal4j.api.ctrl.enums;

public enum Json {
	/** HTML*/ HTML(0),
	/** JSON*/ JSON(1),
	;

	private int value;
	private Json(int value) {
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
