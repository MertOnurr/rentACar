package com.kodlamaio.rentACar2.business.concretes;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.rentACar2.business.abstracts.RentalService;
import com.kodlamaio.rentACar2.business.requests.Rental.CreateRentalRequest;
import com.kodlamaio.rentACar2.business.requests.Rental.DeleteRentalRequest;
import com.kodlamaio.rentACar2.business.requests.Rental.UpdateRentalRequest;
import com.kodlamaio.rentACar2.business.responces.Rental.GetAllRentalResponce;
import com.kodlamaio.rentACar2.business.responces.Rental.GetRentalResponce;
import com.kodlamaio.rentACar2.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.rentACar2.core.utilities.results.DataResult;
import com.kodlamaio.rentACar2.core.utilities.results.ErrorDataResult;
import com.kodlamaio.rentACar2.core.utilities.results.ErrorResult;
import com.kodlamaio.rentACar2.core.utilities.results.Result;
import com.kodlamaio.rentACar2.core.utilities.results.SuccessDataResult;
import com.kodlamaio.rentACar2.core.utilities.results.SuccessResult;
import com.kodlamaio.rentACar2.dataAccess.CarRepository;
import com.kodlamaio.rentACar2.dataAccess.RentalRepository;
import com.kodlamaio.rentACar2.entities.concretes.Car;
import com.kodlamaio.rentACar2.entities.concretes.Rental;

@Service
public class RentalManager implements RentalService {

	@Autowired
	private RentalRepository rentalRepository;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public Result add(CreateRentalRequest createRentalRequest) {

		Rental rentalToAdd = this.modelMapperService.forRequest().map(createRentalRequest, Rental.class);
		Car carToGet = carRepository.findById(createRentalRequest.getCarId()).get();
		// Customer customer =
		// this.customerRepository.findById(createRentalRequest.getCustomerId()).get();
		long diff = createRentalRequest.getReturnDate().getTime() - createRentalRequest.getPickupDate().getTime();
		long time = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		rentalToAdd.setCar(carToGet);
		rentalToAdd.setTotalDays((int) time);
		if (carToGet.getReturnCityId() == carToGet.getPickupCityId() && carToGet.getState() == "avaliable") {

			rentalToAdd.setTotalPrice((rentalToAdd.getTotalDays() * carToGet.getDailyPrice()));
		} else {
			rentalToAdd.setTotalPrice((rentalToAdd.getTotalDays() * carToGet.getDailyPrice()) + 750);
		}
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteRentalRequest deleteRentalRequest) {
		rentalRepository.deleteById(deleteRentalRequest.getId());

		return new SuccessResult();
	}

	@Override
	public Result update(UpdateRentalRequest updateRentalRequest) {
		Rental rental = modelMapperService.forRequest().map(updateRentalRequest, Rental.class);

		rentalRepository.save(rental);
		return new SuccessResult();
	}

	@Override
	public DataResult<Rental> getById(GetRentalResponce getRentalResponce) {
		Rental rentalToGet = this.modelMapperService.forResponce().map(getRentalResponce, Rental.class);
		rentalToGet = rentalRepository.findById(getRentalResponce.getId()).get();

		return new SuccessDataResult<Rental>(rentalToGet);
	}

	@Override
	public DataResult<List<GetAllRentalResponce>> getAll() {
		List<Rental> rentals = this.rentalRepository.findAll();
		List<GetAllRentalResponce> responce = rentals.stream()
				.map(brand -> this.modelMapperService.forResponce().map(brand, GetAllRentalResponce.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllRentalResponce>>(responce);
	}
}