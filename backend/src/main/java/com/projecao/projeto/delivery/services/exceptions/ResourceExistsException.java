package com.projecao.projeto.delivery.services.exceptions;

public class ResourceExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceExistsException(String msg) {
		super(msg);
	}
}
