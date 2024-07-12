package com.kodlamaio.rentACar2.business.abstracts;

import java.util.List;

import com.kodlamaio.rentACar2.business.requests.Brand.CreateBrandRequest;
import com.kodlamaio.rentACar2.business.requests.Brand.DeleteBrandRequest;
import com.kodlamaio.rentACar2.business.requests.Brand.UpdateBrandRequest;
import com.kodlamaio.rentACar2.business.responces.Brand.GetAllBrandResponce;
import com.kodlamaio.rentACar2.business.responces.Brand.GetBrandResponce;
import com.kodlamaio.rentACar2.core.utilities.results.DataResult;
import com.kodlamaio.rentACar2.core.utilities.results.Result;
import com.kodlamaio.rentACar2.entities.concretes.Brand;

public interface BrandService {
	Result add(CreateBrandRequest createBrandRequest);

	Result delete(DeleteBrandRequest deleteBrandRequest);

	Result update(UpdateBrandRequest updateBrandRequest);

	DataResult<Brand> getById(GetBrandResponce getBrandResponce);

	DataResult<List<GetAllBrandResponce>> getAll();

	
	
}
