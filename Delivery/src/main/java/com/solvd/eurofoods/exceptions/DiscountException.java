package main.java.com.solvd.eurofoods.exceptions;


public class DiscountException extends Exception {
	
	private static final long serialVersionUID = 1425083337671534962L;
	private double sum;
	public double getSum() {
		return sum;
		}
	public DiscountException (String message, double s) {
		super(message);
		sum=s;
		}
}

