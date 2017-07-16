package com.iyher.crystalsignal4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

public class Client {
	private static final String CONFIG_PATH = "config.properties";
	private static final String BASE_URL_KEY = "baseUrl";

	private final URI baseUrl;

	private HttpClient client;

	public Client() throws IOException {
		try(InputStream is = ClassLoader.getSystemResourceAsStream(CONFIG_PATH)) {
			Properties prop = new Properties();
			prop.load(is);
			this.baseUrl = new URI(prop.getProperty(BASE_URL_KEY));
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException("コンフィグファイルに書かれているURLが不正", e);
		}
		createClient();
	}

	public Client(String baseUrl) {
		try {
			this.baseUrl = new URI(baseUrl);
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e);
		}
		createClient();
	}

	private void createClient() {
		client = HttpClientBuilder.create().build();
	}

	public void execute(Request req) {
		final URI uri;
		try {
			uri = new URIBuilder(baseUrl).setParameters(req.getQueryParams()).build();
		} catch (URISyntaxException e) {
			throw new RuntimeException("起きないはず、、、", e);
		}

		HttpGet get = new HttpGet(uri);
		try {
			HttpResponse res = client.execute(get);
			if(res.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new RuntimeException("OK以外の応答が来た");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
