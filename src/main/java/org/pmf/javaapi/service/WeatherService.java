package org.pmf.javaapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pmf.javaapi.client.WeatherClient;
import org.pmf.javaapi.model.ApiResponse;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherService {

	private String city = "London";
	private final WeatherClient weatherClient;

	public ApiResponse getCurrent(String city) {
		if (city == null) {
			city = this.city;
		}
		return this.weatherClient.getCurrent(city);
	}

	public ApiResponse getForecast(String city) {
		return weatherClient.getForecast(city);
	}
}
