package com.kodlamaio.rentACar2.business.abstracts;

import java.util.List;

import com.kodlamaio.rentACar2.business.requests.Color.CreateColorRequest;
import com.kodlamaio.rentACar2.business.requests.Color.DeleteColorRequest;
import com.kodlamaio.rentACar2.business.requests.Color.UpdateColorRequest;
import com.kodlamaio.rentACar2.business.responces.Color.GetAllColorResponce;
import com.kodlamaio.rentACar2.business.responces.Color.GetColorResponce;
import com.kodlamaio.rentACar2.core.utilities.results.DataResult;
import com.kodlamaio.rentACar2.core.utilities.results.Result;
import com.kodlamaio.rentACar2.entities.concretes.Color;

public interface ColorService {
	Result add(CreateColorRequest createColorRequest);

	Result delete(DeleteColorRequest deleteColorRequest);

	Result update(UpdateColorRequest updateColorRequest);

	DataResult<Color> getById(GetColorResponce getColorResponce);

	DataResult<List<GetAllColorResponce>> getAll();
}
