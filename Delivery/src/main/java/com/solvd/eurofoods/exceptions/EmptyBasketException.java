package main.java.com.solvd.eurofoods.exceptions;

public class EmptyBasketException extends BasketException {
    private static final long serialVersionUID = 6944640804378696637L;

	public EmptyBasketException(String message) {
        super(message);
    }
}