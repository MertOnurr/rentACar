package com.kodlamaio.rentACar2.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.rentACar2.business.abstracts.BrandService;
import com.kodlamaio.rentACar2.business.requests.Brand.CreateBrandRequest;
import com.kodlamaio.rentACar2.business.requests.Brand.DeleteBrandRequest;
import com.kodlamaio.rentACar2.business.requests.Brand.UpdateBrandRequest;
import com.kodlamaio.rentACar2.business.responces.Brand.GetAllBrandResponce;
import com.kodlamaio.rentACar2.business.responces.Brand.GetBrandResponce;
import com.kodlamaio.rentACar2.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.rentACar2.core.utilities.results.DataResult;
import com.kodlamaio.rentACar2.core.utilities.results.Result;
import com.kodlamaio.rentACar2.core.utilities.results.SuccessResult;
import com.kodlamaio.rentACar2.entities.concretes.Brand;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
	@Autowired
	private BrandService brandService;
	private ModelMapperService modelMapperService;

	@PostMapping("/add")
	public Result Add(@RequestBody CreateBrandRequest createBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		brandService.add(createBrandRequest);
		return new SuccessResult();
	}

	@PostMapping("/delete")
	public Result Delete(@RequestBody DeleteBrandRequest deleteBrandRequest) {
		brandService.delete(deleteBrandRequest);
		return new SuccessResult();
	}

	@PostMapping("/update")
	public Result Update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		return new SuccessResult();
	}

	@GetMapping("/getbyid")
	public DataResult<Brand> getById(@RequestBody GetBrandResponce getBrandResponce) {
		return this.brandService.getById(getBrandResponce);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllBrandResponce>> getAll() {
		return this.brandService.getAll();

	}

}
