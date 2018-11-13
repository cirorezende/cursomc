package com.nelioalves.cursomc.service.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8195098113047506365L;

	public ObjectNotFoundException(String arg0) {
		super(arg0);
	}

	public ObjectNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
