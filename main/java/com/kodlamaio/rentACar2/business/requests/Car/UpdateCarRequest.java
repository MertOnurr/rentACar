package com.kodlamaio.rentACar2.business.requests.Car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
	
		private int brandId;
		private int colorId;
		// @NotEmpty
		// @NotNull(message = "")
		// @Size(min = 2)
		private String description;
		// @Min(value = 10)
		private double dailyPrice;
		private String state = "avaliable";
		// private String plaque;
		// private String kmCount;
		private Integer pickupCityId;
		private Integer returnCityId;
	}

