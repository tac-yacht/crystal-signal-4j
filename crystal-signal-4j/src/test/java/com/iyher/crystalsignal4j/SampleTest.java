package com.iyher.crystalsignal4j;

import java.io.IOException;

import org.junit.Test;

import com.iyher.crystalsignal4j.api.ctrl.BlinkRequest;

public class SampleTest {
	@Test
	public void samplesend() throws IOException {
		Client client = new Client();
		client.execute(new BlinkRequest());
	}
}
