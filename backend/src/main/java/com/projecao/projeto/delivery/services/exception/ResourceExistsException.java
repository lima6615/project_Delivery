package com.projecao.projeto.delivery.services.exception;

public class ResourceExistsException extends RuntimeException{

    public ResourceExistsException(String msg){
        super(msg);
    }
}
