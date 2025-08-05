package com.solvd.eurofoods.model;

import com.solvd.eurofoods.exceptions.DiscountException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Discount {

    private static final Logger logger = LogManager.getLogger(Discount.class);

    private String title;
    private String info;
    private int value;

    public Discount(String title, String info, int value) {
        this.title = title;
        this.info = info;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public float getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public float calculateValue(Account c) {
        return this.value;
    }

    public final double calculateNewPrice(double price) throws DiscountException, ArithmeticException {
        double discountAmount = (price * value) / 100;
        double newPrice = price - discountAmount;
        double priceDifference = (price - newPrice);

        try {
            if (price == 0) {
                throw new ArithmeticException("Zero price");
            }

            if (priceDifference < 0) {
                throw new DiscountException("Discount is bigger than price: ", priceDifference);
            }
            if (priceDifference > 400) {
                throw new DiscountException("Price with discount has a difference more "
                		+ "than 400 hrn. Apply a smaller discount for this product", 
                		priceDifference);
            }
        } catch (ArithmeticException | DiscountException e) {
            logger.error(e.getMessage());
            if (e instanceof DiscountException) {
                logger.error("Sum: {}", ((DiscountException) e).getSum());
            }
        } finally {
            return newPrice;
        }
    }
}
