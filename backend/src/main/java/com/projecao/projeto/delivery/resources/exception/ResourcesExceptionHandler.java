package com.projecao.projeto.delivery.resources.exception;

import com.projecao.projeto.delivery.services.exception.DatabaseException;
import com.projecao.projeto.delivery.services.exception.ResourceExistsException;
import com.projecao.projeto.delivery.services.exception.ResourceEmptyException;
import com.projecao.projeto.delivery.services.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourcesExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardErro> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String err = "Resource Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardErro standardErro = new StandardErro(Instant.now(), status.value(), err, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardErro);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardErro> dataBase(DatabaseException e, HttpServletRequest request){
        String err = "Database Exception";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardErro standardErro = new StandardErro(Instant.now(), status.value(), err, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardErro);
    }

    @ExceptionHandler(ResourceExistsException.class)
    public ResponseEntity<StandardErro> Resourcexists(ResourceExistsException e, HttpServletRequest request){
        String err = "Resource Already Exists";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardErro standardErro = new StandardErro(Instant.now(), status.value(), err, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardErro);
    }

    @ExceptionHandler(ResourceEmptyException.class)
    public ResponseEntity<StandardErro> ResourceEmpty(ResourceEmptyException e, HttpServletRequest request){
        String err = "Resource Empty";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardErro standardErro = new StandardErro(Instant.now(), status.value(), err, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardErro);
    }
}
