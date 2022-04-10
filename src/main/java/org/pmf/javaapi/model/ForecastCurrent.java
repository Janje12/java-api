package org.pmf.javaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigDecimal;
import java.util.Map;

public class ForecastCurrent {

	@JsonProperty(value = "temp_c")
	private BigDecimal temperature;
	private String condition;
	@JsonProperty(value = "wind_kph")
	private BigDecimal windSpeed;
	@JsonProperty(value = "wind_dir")
	private String windDirection;
	private int humidity;
	private int cloud;
	@JsonProperty(value = "feelslike_c")
	private BigDecimal feelsLike;
	private BigDecimal uv;

	@JsonSetter(value = "condition")
	private void setCondition(Map<String, String> condition) {
		this.condition = condition.getOrDefault("text", "Sunny");
	}


}
