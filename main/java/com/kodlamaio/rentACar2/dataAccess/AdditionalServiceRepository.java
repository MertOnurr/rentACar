package com.kodlamaio.rentACar2.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.rentACar2.entities.concretes.AdditionalService;

public interface AdditionalServiceRepository extends JpaRepository<AdditionalService, Integer>{

}
