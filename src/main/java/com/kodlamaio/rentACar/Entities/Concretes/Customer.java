package com.kodlamaio.rentACar.Entities.Concretes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends User {
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<Rental> rentals;
	
	@ManyToOne()
	@JoinColumn(name = "address")
	private Address address;

}