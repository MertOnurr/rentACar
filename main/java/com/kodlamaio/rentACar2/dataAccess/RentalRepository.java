package com.kodlamaio.rentACar2.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.rentACar2.entities.concretes.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
	
}
