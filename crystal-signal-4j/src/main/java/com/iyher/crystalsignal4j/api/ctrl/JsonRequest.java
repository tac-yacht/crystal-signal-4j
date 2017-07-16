package com.iyher.crystalsignal4j.api.ctrl;

import java.util.Collections;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.iyher.crystalsignal4j.Request;
import com.iyher.crystalsignal4j.api.ctrl.enums.Json;

/**
 * JSONによる状態取得リクエスト
 * @author tac-yacht
 */
public class JsonRequest implements Request {

	private static final String key = "json";
	private static final JsonRequest instance = new JsonRequest();

	private final Json json;

	private JsonRequest() {
		json = Json.JSON;
	}

	public JsonRequest(Json json) {
		this.json = json;
	}

	public static JsonRequest getInstance() {
		return instance;
	}

	/** {@inheritDoc}*/
	@Override
	public List<NameValuePair> getQueryParams() {
		return Collections.singletonList(new BasicNameValuePair(key,String.valueOf(json.getValue())));
	}

}
