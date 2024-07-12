package com.kodlamaio.rentACar2.core.utilities.results;

import com.kodlamaio.rentACar2.core.utilities.results.DataResult;

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T data, String message) {
		super(data, true, message);
	}

	public SuccessDataResult(T data) {
		super(data, true);
	}

	public SuccessDataResult(String message) {
		super(null, true, message);
	}

	public SuccessDataResult() {
		super(null, true);
	}
}
