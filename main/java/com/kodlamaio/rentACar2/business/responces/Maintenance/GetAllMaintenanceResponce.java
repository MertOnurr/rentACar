package com.kodlamaio.rentACar2.business.responces.Maintenance;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllMaintenanceResponce {
	private int id;	
	private Date sendDate;
	private Date returnDate;
	private int carId;
}
