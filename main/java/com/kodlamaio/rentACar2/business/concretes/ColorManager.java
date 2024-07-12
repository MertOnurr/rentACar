package com.kodlamaio.rentACar2.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.rentACar2.business.abstracts.ColorService;
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
import com.kodlamaio.rentACar2.dataAccess.ColorRepository;
import com.kodlamaio.rentACar2.entities.concretes.Color;

@Service
public class ColorManager implements ColorService {
	@Autowired
	private ColorRepository colorRepository;
	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public Result add(CreateColorRequest createColorRequest) {
		Color color = modelMapperService.forRequest().map(createColorRequest, Color.class);
		colorRepository.save(color);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteColorRequest deleteColorRequest) {
		colorRepository.deleteById(deleteColorRequest.getId());
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateColorRequest updateColorRequest) {
		Color color = modelMapperService.forRequest().map(updateColorRequest, Color.class);

		colorRepository.save(color);
		return new SuccessResult();
	}

	@Override
	public DataResult<Color> getById(GetColorResponce getColorResponce) {

		Color color = this.modelMapperService.forResponce().map(getColorResponce, Color.class);
		color = this.colorRepository.findById(getColorResponce.getId()).get();
		return new SuccessDataResult<Color>(color);
	}

	@Override
	public DataResult<List<GetAllColorResponce>> getAll() {
		List<Color> colors = this.colorRepository.findAll();
		List<GetAllColorResponce> responce = colors.stream()
				.map(color -> this.modelMapperService.forResponce().map(color, GetAllColorResponce.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllColorResponce>>(responce);
	}

}
