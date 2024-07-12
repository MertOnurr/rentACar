package com.kodlamaio.rentACar2.business.responces.Rental;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllRentalResponce {
	private int id;
	private Date pickUpdate;
	private Date returnDate;
	private double totalDays;
	private double totalPrice;
	private int carId;
	private int additionalServiceId;
}
