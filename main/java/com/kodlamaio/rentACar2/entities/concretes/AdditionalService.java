package com.kodlamaio.rentACar2.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "additional_service")
public class AdditionalService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "day")
	private int day;

	@Column(name = "total_price")
	private double totalPrice;

	 @ManyToOne
	 @JoinColumn(name = "additionalItem_id")
	 private AdditionalItem additionalItem;

//	@OneToMany(mappedBy = "additionalService")
	// private List<RentalDetail> rentalDetail;

}
