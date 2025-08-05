package com.solvd.eurofoods.exceptions;

public class DuplicateAccountException extends AccountException {
    private static final long serialVersionUID = 2710557288328153983L;

	public DuplicateAccountException(String message) {
        super(message);
    }
}
