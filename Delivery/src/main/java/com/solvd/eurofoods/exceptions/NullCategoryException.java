package com.solvd.eurofoods.exceptions;

public class NullCategoryException extends CategoryException {
    private static final long serialVersionUID = 3318174435617469902L;

	public NullCategoryException(String message) {
        super(message);
    }
}