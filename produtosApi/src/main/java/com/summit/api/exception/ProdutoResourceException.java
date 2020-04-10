package com.summit.api.exception;

public class ProdutoResourceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3188935602734356923L;

	public ProdutoResourceException() {
		super();
	}

	public ProdutoResourceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProdutoResourceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProdutoResourceException(String message) {
		super(message);
	}

	public ProdutoResourceException(Throwable cause) {
		super(cause);
	}

}
