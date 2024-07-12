package com.kodlamaio.rentACar2.business.requests.Maintenance;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateMaintenanceRequest {
	private Date sendDate;
	private Date returnDate;
	private int carId;
}
