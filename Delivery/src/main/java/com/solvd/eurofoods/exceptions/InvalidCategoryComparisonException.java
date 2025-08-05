package com.solvd.eurofoods.exceptions;

public class InvalidCategoryComparisonException extends CategoryException {
    private static final long serialVersionUID = 7655775621627687706L;

	public InvalidCategoryComparisonException(String message) {
        super(message);
    }
}
