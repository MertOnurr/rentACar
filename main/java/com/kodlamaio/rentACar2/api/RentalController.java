package com.kodlamaio.rentACar2.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.rentACar2.business.abstracts.RentalService;
import com.kodlamaio.rentACar2.business.requests.Rental.CreateRentalRequest;
import com.kodlamaio.rentACar2.business.requests.Rental.DeleteRentalRequest;
import com.kodlamaio.rentACar2.business.requests.Rental.UpdateRentalRequest;
import com.kodlamaio.rentACar2.business.responces.Rental.GetAllRentalResponce;
import com.kodlamaio.rentACar2.business.responces.Rental.GetRentalResponce;
import com.kodlamaio.rentACar2.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.rentACar2.core.utilities.results.DataResult;
import com.kodlamaio.rentACar2.core.utilities.results.ErrorResult;
import com.kodlamaio.rentACar2.core.utilities.results.Result;
import com.kodlamaio.rentACar2.core.utilities.results.SuccessResult;
import com.kodlamaio.rentACar2.entities.concretes.Rental;

@RestController
@RequestMapping("api/rentals")
public class RentalController {
	@Autowired
	private RentalService rentalService;
	private ModelMapperService modelMapperService;

	@PostMapping("/add")

	public Result add(@RequestBody CreateRentalRequest createRentalRequest) {
		var result = rentalService.add(createRentalRequest);
		if (result.isSuccess()) {
			return new SuccessResult("başarıyla kiralandı");
		} else {
			return new ErrorResult("eklenemedi sorun!");
		}
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteRentalRequest deleteRentalRequest) {
		rentalService.delete(deleteRentalRequest);
		return new SuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody UpdateRentalRequest updateRentalRequest) {
		rentalService.update(updateRentalRequest);
		return new SuccessResult();
	}

	@GetMapping("/getbyid")
	public DataResult<Rental> getById(GetRentalResponce getRentalResponce) {

		return this.rentalService.getById(getRentalResponce);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllRentalResponce>> getAll() {
		return this. rentalService.getAll();
	}
}
