package com.iyher.crystalsignal4j;

import java.util.List;

import org.apache.http.NameValuePair;

public interface Request {

	/**
	 * クエリを取得します。
	 * @return
	 */
	List<NameValuePair> getQueryParams();
}
