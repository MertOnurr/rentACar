package com.kodlamaio.rentACar2.api;

import java.util.List;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.rentACar2.business.abstracts.CarService;
import com.kodlamaio.rentACar2.business.requests.Car.CreateCarRequest;
import com.kodlamaio.rentACar2.business.requests.Car.DeleteCarRequest;
import com.kodlamaio.rentACar2.business.requests.Car.UpdateCarRequest;
import com.kodlamaio.rentACar2.business.responces.Car.GetAllCarResponce;
import com.kodlamaio.rentACar2.business.responces.Car.GetCarResponce;
import com.kodlamaio.rentACar2.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.rentACar2.core.utilities.results.DataResult;
import com.kodlamaio.rentACar2.core.utilities.results.Result;
import com.kodlamaio.rentACar2.core.utilities.results.SuccessResult;
import com.kodlamaio.rentACar2.entities.concretes.Car;

@RestController
@RequestMapping("api/cars")
public class CarsController {
	@Autowired
	private CarService carService;
	private ModelMapperService modelMapperService;

	@PostMapping("/add")
	public Result Add(@RequestBody CreateCarRequest createCarRequest) {
		Car car = modelMapperService.forRequest().map(createCarRequest,Car.class);
		return new SuccessResult();
	}

	@PostMapping("/delete")
	public Result Delete(@RequestBody DeleteCarRequest deleteCarRequest) {
		carService.delete(deleteCarRequest);
		return new SuccessResult();
	}

	@PostMapping("/update")
	public Result Update(@RequestBody UpdateCarRequest updateCarRequest) {
		Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);

		return new SuccessResult();
	}

	@GetMapping("/getbyid")
	public DataResult<Car> getById(@RequestBody GetCarResponce getCarResponce) {
		return this. carService.getById(getCarResponce);

	}

	@GetMapping("/getall")
	public DataResult<List<GetAllCarResponce>> getAll() {
		return this. carService.getAll();
	}
}
