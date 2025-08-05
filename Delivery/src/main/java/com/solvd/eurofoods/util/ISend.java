package com.solvd.eurofoods.util;

public interface ISend {
	
	default void formContents() {} 
	default void formFetch() {}
	static void fieldsValidationCheck() {}
	default void sending() {}
	default void returning() {}
}
