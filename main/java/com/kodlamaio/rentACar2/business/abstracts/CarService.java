package com.kodlamaio.rentACar2.business.abstracts;

import java.util.List;

import com.kodlamaio.rentACar2.business.requests.Car.CreateCarRequest;
import com.kodlamaio.rentACar2.business.requests.Car.DeleteCarRequest;
import com.kodlamaio.rentACar2.business.requests.Car.UpdateCarRequest;
import com.kodlamaio.rentACar2.business.responces.Car.GetAllCarResponce;
import com.kodlamaio.rentACar2.business.responces.Car.GetCarResponce;
import com.kodlamaio.rentACar2.core.utilities.results.DataResult;
import com.kodlamaio.rentACar2.core.utilities.results.Result;
import com.kodlamaio.rentACar2.entities.concretes.Car;

public interface CarService {
	Result add(CreateCarRequest createCarRequest);

	Result delete(DeleteCarRequest deleteCarRequest);

	Result update(UpdateCarRequest updateCarRequest);

	DataResult<Car> getById(GetCarResponce getCarResponce);

	DataResult<List<GetAllCarResponce>> getAll();
}
