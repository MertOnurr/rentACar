package com.kodlamaio.rentACar2.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cars")
public class Car {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "plaque")
	private String plaque;
	@Column(name = "kmCount")
	private int kmCount;
	@Column(name = "description")
	private String description;
	@Column(name = "daily_price")
	private double dailyPrice;
	@Column(name = "return_city_id")
	private int ReturnCityId;
	@Column(name = "pickup_city_id")
	private int PickupCityId;
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;
	@Column(name = "state")
	private String state = "Available";
	@OneToMany(mappedBy = "car")
	List<Maintenance> maintenances;

	@OneToMany(mappedBy = "car")
	List<Rental> rentals;
}
