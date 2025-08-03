package main.java.com.solvd.eurofoods.exceptions;

public class OrderException extends Exception {
    private static final long serialVersionUID = 1452555675716261525L;

	public OrderException(String message) {
        super(message);
    }
}