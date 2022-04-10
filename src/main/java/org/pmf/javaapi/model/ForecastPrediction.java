package org.pmf.javaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
public class ForecastPrediction {

	private LocalDate date;
	@JsonProperty(value = "maxtemp_c")
	private BigDecimal maxTemperature;
	@JsonProperty(value = "mintemp_c")
	private BigDecimal minTemperature;
	@JsonProperty(value = "avgtemp_c")
	private BigDecimal avgTemperature;
	@JsonProperty(value = "maxwind_kph")
	private BigDecimal maxWindSpeed;
	private String condition;
	private BigDecimal uv;
	@JsonProperty(value = "avghumidity")
	private BigDecimal avgHumidity;

	@JsonSetter(value = "condition")
	public void setCondition(Map<String, String> condition) {
		this.condition = condition.getOrDefault("condition", "Sunny");
	}

}
