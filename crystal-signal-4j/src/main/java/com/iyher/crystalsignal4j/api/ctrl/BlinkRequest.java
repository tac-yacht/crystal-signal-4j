package com.iyher.crystalsignal4j.api.ctrl;

import java.awt.Color;
import java.util.HashMap;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import com.iyher.crystalsignal4j.Request;
import com.iyher.crystalsignal4j.api.ctrl.enums.Mode;

/**
 * 発光リクエスト
 * @author tac-yacht
 *
 */
public class BlinkRequest implements Request {

	private enum key {
		color,mode,period,repeat
	}

	private static final String COLOR_SEPARATOR = ",";

	private int red;
	private int green;
	private int blue;

	private Mode mode;

	private Long period;

	private Integer repeat;

	public BlinkRequest() {
		setRGB(255, 255, 255);
	}

	public BlinkRequest(int red, int green, int blue) {
		setRGB(red, green, blue);
	}

	public BlinkRequest(Color color) {
		setRGB(color.getRed(), color.getGreen(), color.getBlue());
	}

	public BlinkRequest(int red, int green, int blue, Mode mode) {
		setRGB(red, green, blue);
		this.mode = mode;
	}

	public BlinkRequest(Color color, Mode mode) {
		setRGB(color.getRed(), color.getGreen(), color.getBlue());
		this.mode = mode;
	}

	public BlinkRequest(int red, int green, int blue, Mode mode,long period) {
		setRGB(red, green, blue);
		this.mode = mode;
		this.period = period;
	}

	public BlinkRequest(Color color, Mode mode, long period) {
		setRGB(color.getRed(), color.getGreen(), color.getBlue());
		this.mode = mode;
		this.period = period;
	}

	public BlinkRequest(int red, int green, int blue, Mode mode, int repeat) {
		setRGB(red, green, blue);
		this.mode = mode;
		this.repeat = repeat;
	}

	public BlinkRequest(Color color, Mode mode, int repeat) {
		setRGB(color.getRed(), color.getGreen(), color.getBlue());
		this.mode = mode;
		this.repeat = repeat;
	}

	public BlinkRequest(int red, int green, int blue, Mode mode,long period, int repeat) {
		setRGB(red, green, blue);
		this.mode = mode;
		this.period = period;
		this.repeat = repeat;
	}

	public BlinkRequest(Color color, Mode mode, long period, int repeat) {
		setRGB(color.getRed(), color.getGreen(), color.getBlue());
		this.mode = mode;
		this.period = period;
		this.repeat = repeat;
	}

	private void setRGB(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	@Override
	public String getQueryString() {
		return new HashMap<String, Object>(){{
			put(key.color.name(), new StringJoiner(COLOR_SEPARATOR)
				.add(String.valueOf(red))
				.add(String.valueOf(green))
				.add(String.valueOf(blue))
			.toString());
			Optional.ofNullable(mode).ifPresent(mode -> {
				put(key.mode.name(), mode.getValue());
			});
			Optional.ofNullable(period).ifPresent(period -> {
				put(key.period.name(), period);
			});
			Optional.ofNullable(repeat).ifPresent(repeat -> {
				put(key.repeat.name(), repeat);
			});
		}}.entrySet().stream()
		.map(entry -> entry.getKey() + KV_SEPARATOR + String.valueOf(entry.getValue()))
		.collect(Collectors.joining(PAIR_DELIMITER));
	}
}
