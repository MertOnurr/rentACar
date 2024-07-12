package com.kodlamaio.rentACar2.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.rentACar2.business.abstracts.ColorService;
import com.kodlamaio.rentACar2.business.requests.Brand.DeleteBrandRequest;
import com.kodlamaio.rentACar2.business.requests.Brand.UpdateBrandRequest;
import com.kodlamaio.rentACar2.business.requests.Color.CreateColorRequest;
import com.kodlamaio.rentACar2.business.requests.Color.DeleteColorRequest;
import com.kodlamaio.rentACar2.business.requests.Color.UpdateColorRequest;
import com.kodlamaio.rentACar2.business.responces.Color.GetAllColorResponce;
import com.kodlamaio.rentACar2.business.responces.Color.GetColorResponce;
import com.kodlamaio.rentACar2.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.rentACar2.core.utilities.results.DataResult;
import com.kodlamaio.rentACar2.core.utilities.results.Result;
import com.kodlamaio.rentACar2.core.utilities.results.SuccessDataResult;
import com.kodlamaio.rentACar2.core.utilities.results.SuccessResult;
import com.kodlamaio.rentACar2.entities.concretes.Car;
import com.kodlamaio.rentACar2.entities.concretes.Color;

@RestController
@RequestMapping("api/colors")
public class ColorsController {
	@Autowired
	private ColorService colorService;
	private ModelMapperService modelMapperService;

	@PostMapping("/add")
	private Result Add(@RequestBody CreateColorRequest createColorRequest) {
		Color color = modelMapperService.forRequest().map(createColorRequest, Color.class);
		return new SuccessResult();
	}

	@PostMapping("/delete")
	private Result Delete(@RequestBody DeleteColorRequest deleteColorRequest) {
		colorService.delete(deleteColorRequest);
		return new SuccessResult();

	}

	@PostMapping("/update")
	private Result Update(@RequestBody UpdateColorRequest updateColorRequest) {
		Color color = modelMapperService.forRequest().map(updateColorRequest, Color.class);
		return new SuccessResult();

	}

	@GetMapping("/getbyid")
	private DataResult<Color> getById(@RequestBody GetColorResponce getColorResponce) {
		return this.colorService.getById(getColorResponce);
	}

	@GetMapping("/getall")
	private DataResult<List<GetAllColorResponce>> getAll() {
		return this.colorService.getAll();
	}
}
