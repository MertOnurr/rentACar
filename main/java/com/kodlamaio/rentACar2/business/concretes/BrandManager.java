package com.kodlamaio.rentACar2.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.rentACar2.business.abstracts.BrandService;
import com.kodlamaio.rentACar2.business.requests.Brand.CreateBrandRequest;
import com.kodlamaio.rentACar2.business.requests.Brand.DeleteBrandRequest;
import com.kodlamaio.rentACar2.business.requests.Brand.UpdateBrandRequest;
import com.kodlamaio.rentACar2.business.responces.Brand.GetAllBrandResponce;
import com.kodlamaio.rentACar2.business.responces.Brand.GetBrandResponce;
import com.kodlamaio.rentACar2.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.rentACar2.core.utilities.results.DataResult;
import com.kodlamaio.rentACar2.core.utilities.results.Result;
import com.kodlamaio.rentACar2.core.utilities.results.SuccessDataResult;
import com.kodlamaio.rentACar2.core.utilities.results.SuccessResult;
import com.kodlamaio.rentACar2.dataAccess.BrandRepository;
import com.kodlamaio.rentACar2.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService {
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public Result add(CreateBrandRequest createBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		brandRepository.save(brand);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteBrandRequest deleteBrandRequest) {
		brandRepository.deleteById(deleteBrandRequest.getId());
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);

		brandRepository.save(brand);
		return new SuccessResult();
	}

	@Override
	public DataResult<Brand> getById(GetBrandResponce getBrandResponce) {
		Brand brand = this.modelMapperService.forResponce().map(getBrandResponce, Brand.class);
		brand = this.brandRepository.findById(getBrandResponce.getId()).get();
		return new SuccessDataResult<Brand>(brand);
	}

	@Override
	public DataResult<List<GetAllBrandResponce>> getAll() {
		List<Brand> brands = this.brandRepository.findAll();
		List<GetAllBrandResponce> response = brands.stream()
				.map(brand -> this.modelMapperService.forResponce().map(brand, GetAllBrandResponce.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllBrandResponce>>(response);
	}
}
