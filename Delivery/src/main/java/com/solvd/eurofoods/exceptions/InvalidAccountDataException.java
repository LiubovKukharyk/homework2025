package com.solvd.eurofoods.exceptions;

public class InvalidAccountDataException extends AccountException {
    private static final long serialVersionUID = -615029914726591138L;

	public InvalidAccountDataException(String message) {
        super(message);
    }
}
