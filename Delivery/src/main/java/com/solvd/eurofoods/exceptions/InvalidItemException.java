package com.solvd.eurofoods.exceptions;


public class InvalidItemException extends RuntimeException {
    private static final long serialVersionUID = 6114383372789377083L;

	public InvalidItemException(String message) {
        super(message);
    }
}