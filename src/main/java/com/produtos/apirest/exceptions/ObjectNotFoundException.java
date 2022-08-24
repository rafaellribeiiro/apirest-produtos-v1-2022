package com.produtos.apirest.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -7582789971737133689L;

	public ObjectNotFoundException(String msg){
		super(msg);
	}
	public ObjectNotFoundException(String msg, Throwable cause){
		super(msg, cause);
	}
}
