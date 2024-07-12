package com.kodlamaio.rentACar2.business.concretes;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.rentACar2.business.abstracts.MaintenanceService;
import com.kodlamaio.rentACar2.business.requests.Maintenance.CreateMaintenanceRequest;
import com.kodlamaio.rentACar2.business.requests.Maintenance.DeleteMaintenanceRequest;
import com.kodlamaio.rentACar2.business.requests.Maintenance.UpdateMaintenanceRequest;
import com.kodlamaio.rentACar2.business.responces.Maintenance.GetAllMaintenanceResponce;
import com.kodlamaio.rentACar2.business.responces.Maintenance.GetMaintenanceResponce;
import com.kodlamaio.rentACar2.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.rentACar2.core.utilities.results.DataResult;
import com.kodlamaio.rentACar2.core.utilities.results.Result;
import com.kodlamaio.rentACar2.core.utilities.results.SuccessDataResult;
import com.kodlamaio.rentACar2.core.utilities.results.SuccessResult;
import com.kodlamaio.rentACar2.dataAccess.CarRepository;
import com.kodlamaio.rentACar2.dataAccess.MaintenanceRepository;
import com.kodlamaio.rentACar2.entities.concretes.Car;
import com.kodlamaio.rentACar2.entities.concretes.Color;
import com.kodlamaio.rentACar2.entities.concretes.Maintenance;

@Service
public class MaintenanceManager implements MaintenanceService {
	@Autowired
	private MaintenanceRepository maintenanceRepository;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public Result Add(CreateMaintenanceRequest createMaintenanceRequest) {
		Maintenance maintenance = this.modelMapperService.forRequest().map(createMaintenanceRequest, Maintenance.class);
		Car carToUpdate = new Car();
		carToUpdate = carRepository.findById(createMaintenanceRequest.getCarId()).get();
		carToUpdate.setState("maintenance");
		maintenanceRepository.save(maintenance);
		carRepository.save(carToUpdate);
		return new SuccessResult("Bakım başarıyla eklenmiştir");
	}

	@Override
	public Result Delete(DeleteMaintenanceRequest deleteMaintenanceRequest) {
		maintenanceRepository.deleteById(deleteMaintenanceRequest.getId());
		return new SuccessResult();
	}

	@Override
	public Result Update(UpdateMaintenanceRequest updateMaintenanceRequest) {
		Maintenance maintenance = this.modelMapperService.forRequest().map(updateMaintenanceRequest, Maintenance.class);
		maintenanceRepository.save(maintenance);
		return new SuccessResult();
	}

	@Override
	public DataResult<Maintenance> getById(GetMaintenanceResponce maintenanceResponce) {
		Maintenance maintenanceToGet = this.modelMapperService.forResponce().map(maintenanceResponce,
				Maintenance.class);
		maintenanceToGet = this.maintenanceRepository.findById(maintenanceResponce.getId()).get();
		return new SuccessDataResult<Maintenance>(maintenanceToGet);
	}

	@Override
	public DataResult<List<GetAllMaintenanceResponce>> getAll() {
		List<Maintenance> maintenances = this.maintenanceRepository.findAll();
		List<GetAllMaintenanceResponce> responce = maintenances.stream().map(
				maintenance -> this.modelMapperService.forResponce().map(maintenance, GetAllMaintenanceResponce.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllMaintenanceResponce>>(responce);
	}
}