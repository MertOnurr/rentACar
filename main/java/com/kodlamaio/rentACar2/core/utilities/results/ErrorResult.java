package com.kodlamaio.rentACar2.core.utilities.results;

import com.kodlamaio.rentACar2.core.utilities.results.Result;

public class ErrorResult extends Result {
	public ErrorResult() {
		super(false);
	}

	public ErrorResult(String message) {
		super(false, message);
	}
}