package com.kodlamaio.rentACar2.core.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	ModelMapper forResponce();

	ModelMapper forRequest();
}
