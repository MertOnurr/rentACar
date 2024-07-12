package com.kodlamaio.rentACar2.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.rentACar2.business.abstracts.CarService;
import com.kodlamaio.rentACar2.business.requests.Car.CreateCarRequest;
import com.kodlamaio.rentACar2.business.requests.Car.DeleteCarRequest;
import com.kodlamaio.rentACar2.business.requests.Car.UpdateCarRequest;
import com.kodlamaio.rentACar2.business.responces.Car.GetAllCarResponce;
import com.kodlamaio.rentACar2.business.responces.Car.GetCarResponce;
import com.kodlamaio.rentACar2.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.rentACar2.core.utilities.results.DataResult;
import com.kodlamaio.rentACar2.core.utilities.results.Result;
import com.kodlamaio.rentACar2.core.utilities.results.SuccessDataResult;
import com.kodlamaio.rentACar2.core.utilities.results.SuccessResult;
import com.kodlamaio.rentACar2.dataAccess.CarRepository;
import com.kodlamaio.rentACar2.entities.concretes.Car;

@Service
public class CarManager implements CarService {
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private ModelMapperService modelMapperService;
    
	@Override
	public Result add(CreateCarRequest createCarRequest) {
		Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);

		carRepository.save(car);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {
		carRepository.deleteById(deleteCarRequest.getId());
		return new SuccessResult("silindi");
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {
		Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
		

		carRepository.save(car);
		return new SuccessResult();
	}

	@Override
	public DataResult<Car> getById(GetCarResponce getCarResponce) {
		Car car = this.modelMapperService.forResponce().map(getCarResponce, Car.class);
		car = this.carRepository.findById(getCarResponce.getId()).get();
		return new SuccessDataResult<Car>(car);
	}

	@Override
	public DataResult<List<GetAllCarResponce>> getAll() {
		List<Car> cars = this.carRepository.findAll();
		List<GetAllCarResponce> responce = cars.stream()
				.map(Car -> this.modelMapperService.forResponce().map(Car,GetAllCarResponce.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllCarResponce>>(responce);
	
	}

}
