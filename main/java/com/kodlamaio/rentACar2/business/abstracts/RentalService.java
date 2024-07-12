package com.kodlamaio.rentACar2.business.abstracts;

import java.util.List;

import com.kodlamaio.rentACar2.business.requests.Rental.CreateRentalRequest;
import com.kodlamaio.rentACar2.business.requests.Rental.DeleteRentalRequest;
import com.kodlamaio.rentACar2.business.requests.Rental.UpdateRentalRequest;
import com.kodlamaio.rentACar2.business.responces.Rental.GetAllRentalResponce;
import com.kodlamaio.rentACar2.business.responces.Rental.GetRentalResponce;
import com.kodlamaio.rentACar2.core.utilities.results.DataResult;
import com.kodlamaio.rentACar2.core.utilities.results.Result;
import com.kodlamaio.rentACar2.entities.concretes.Rental;

public interface RentalService {
	Result add(CreateRentalRequest createRentalRequest);

	Result delete(DeleteRentalRequest deleteRentalRequest);

	Result update(UpdateRentalRequest updateRentalRequest);

	DataResult<Rental> getById(GetRentalResponce getRentalResponce);

	DataResult<List<GetAllRentalResponce>> getAll();

}
