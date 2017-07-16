package com.iyher.crystalsignal4j;

public interface Request {

	/** キーとその値のペアが複数あるときのデリミター */
	public static final String PAIR_DELIMITER = "&";

	/** キーと値のセパレーター */
	public static final String KV_SEPARATOR = "=";

	/**
	 * クエリストリングを取得します。
	 * @return
	 */
	String getQueryString();
}
