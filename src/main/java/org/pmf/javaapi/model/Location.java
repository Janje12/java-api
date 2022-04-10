package org.pmf.javaapi.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Location {

	private String name;
	private String region;
	private String country;
	private BigDecimal lat;
	private BigDecimal lon;
	private LocalDateTime localtime;

	@JsonSetter("localtime")
	public void setLocalTime(String localTime) {
		if (localTime.length() == 15) {
			String[] arr = localTime.split(" ");
			arr[1] = " 0" + arr[1];
			localTime = arr[0] + arr[1];
		}
		localTime = localTime.replace(" ", "T");
		this.localtime = LocalDateTime.parse(localTime);
	}
}
