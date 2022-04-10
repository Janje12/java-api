package org.pmf.javaapi.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ApiResponse {

	private Location location;
	private ForecastCurrent current;

	private List<ForecastPrediction> predictions;

	@JsonSetter(value = "forecast")
	public void setPrediction(Map<String, Object[]> forecast) {
		Object[] days = forecast.get("forecastday");
		System.err.println(days);
		Arrays.stream(days).forEach(day -> predictions.add((ForecastPrediction) day));
	}
}
