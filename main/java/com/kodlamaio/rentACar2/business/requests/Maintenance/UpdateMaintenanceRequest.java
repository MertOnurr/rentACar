package com.kodlamaio.rentACar2.business.requests.Maintenance;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMaintenanceRequest {
	private int id;
	private Date sendDate;
	private Date returnDate;
	private int carId;
	
}
