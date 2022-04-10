package org.pmf.javaapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pmf.javaapi.model.ApiResponse;
import org.pmf.javaapi.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("weather")
@RequiredArgsConstructor
public class WeatherController {

	private final WeatherService weatherService;

	@GetMapping(value = "today")
	public ApiResponse get(@RequestParam(required = false) String city) {
		log.info("Get current weather for city: {}", city);

		return this.weatherService.getCurrent(city);
	}

	@GetMapping(value = "forecast")
	public ApiResponse getForecast(@RequestParam(required = false) String city) {
		log.info("Get forecast weather for city: {}", city);

		return this.weatherService.getForecast(city);
	}
}
