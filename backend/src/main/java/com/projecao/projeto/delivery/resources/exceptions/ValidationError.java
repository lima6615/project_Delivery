package com.projecao.projeto.delivery.resources.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardErro {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Instant timesStamp, Integer status, String error, String message, String path) {
		super(timesStamp, status, error, message, path);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldErro, String message) {
		errors.add(new FieldMessage(fieldErro, message));
	}
}
