package org.pmf.javaapi.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pmf.javaapi.model.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherClient {
	private final String API_KEY = "2ffb7e39acd84bf2a11153907222003";
	private final String BASE_URL = "http://api.weatherapi.com/v1/";
	private final String CURRENT_URI = "current.json";
	private final String FORECAST_URI = "forecast.json";

	private final RestTemplate restTemplate;

	public ApiResponse getCurrent(String city) {
		ResponseEntity<ApiResponse> response = this.restTemplate.getForEntity(BASE_URL + CURRENT_URI +
				"?q=" + city + "&key=" + API_KEY, ApiResponse.class);
		return response.getBody();
	}

	public ApiResponse getForecast(String city) {
		ResponseEntity<ApiResponse> response = this.restTemplate.getForEntity(BASE_URL + FORECAST_URI +
				"?q=" + city + "&days=3&key=" + API_KEY, ApiResponse.class);
		return response.getBody();
	}
}
