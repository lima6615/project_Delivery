package com.projecao.projeto.delivery.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.projecao.projeto.delivery.services.exceptions.DatabaseException;
import com.projecao.projeto.delivery.services.exceptions.ResourceEmptyException;
import com.projecao.projeto.delivery.services.exceptions.ResourceExistsException;
import com.projecao.projeto.delivery.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourcesExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardErro> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String err = "Resource Not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardErro standardErro = new StandardErro(Instant.now(), status.value(), err, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(standardErro);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardErro> dataBase(DatabaseException e, HttpServletRequest request) {
		String err = "Database Exception";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardErro standardErro = new StandardErro(Instant.now(), status.value(), err, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(standardErro);
	}

	@ExceptionHandler(ResourceExistsException.class)
	public ResponseEntity<StandardErro> Resourcexists(ResourceExistsException e, HttpServletRequest request) {
		String err = "Resource Already Exists";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardErro standardErro = new StandardErro(Instant.now(), status.value(), err, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(standardErro);
	}

	@ExceptionHandler(ResourceEmptyException.class)
	public ResponseEntity<StandardErro> ResourceEmpty(ResourceEmptyException e, HttpServletRequest request) {
		String err = "Resource Empty";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardErro standardErro = new StandardErro(Instant.now(), status.value(), err, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(standardErro);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		String err = "Validation exception";
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationError validationErro = new ValidationError(Instant.now(), status.value(), err, e.getMessage(),
				request.getRequestURI());

		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			validationErro.addError(f.getField(), f.getDefaultMessage());
		}
		return ResponseEntity.status(status).body(validationErro);
	}
}
