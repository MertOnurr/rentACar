package com.kodlamaio.rentACar2.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.rentACar2.entities.concretes.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer>{

}
