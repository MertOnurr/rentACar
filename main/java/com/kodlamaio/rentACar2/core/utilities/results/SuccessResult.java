package com.kodlamaio.rentACar2.core.utilities.results;

import com.kodlamaio.rentACar2.core.utilities.results.Result;

public class SuccessResult extends Result {
	public SuccessResult() {
		super(true);
	}

	public SuccessResult(String message) {
		super(true, message);
	}
}
