package com.projecao.projeto.delivery.services.exceptions;

public class ResourceEmptyException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceEmptyException(String msg) {
		super(msg);
	}

}
