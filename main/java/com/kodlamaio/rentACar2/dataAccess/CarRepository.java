package com.kodlamaio.rentACar2.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodlamaio.rentACar2.entities.concretes.Car;
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
