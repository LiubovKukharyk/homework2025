package com.solvd.eurofoods.model;

import java.util.ArrayList;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Payment {

    private static final Logger logger = LoggerFactory.getLogger(Payment.class);

    protected String id;
    protected Float sum;
    protected String cardNumber;
    private enum cardType {
        VISA,
        MASTERCARD,
        AMERICAN_EXPRESS,
        UNIONPAY
    }
    private ArrayList<String> systems = new ArrayList<>(
            Arrays.asList("GOOGLE", "APPLE", "MANUAL")
    );
    private String choice = systems.get(0);
    private String card;

    private Payment(String id, Float sum, String cardNumber,
                    String card, String choice) {
        this.id = id;
        this.sum = sum;
        this.cardNumber = cardNumber;
        this.card = cardType.valueOf(choice).toString();
    }

    public Payment() {
        this.hashCode();
        this.isPaid();
    }

    public void setSystems(String s) {
        systems.add(s);
    }

    public String getSystems(int j) {
        String s = systems.get(j);
        return s;
    }

    public void getSystems() {
        for (int i = 0; i < systems.size(); i++) {
            logger.info(systems.get(i));
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void paymentFormShow() {

        switch (choice) {
            case ("MANUAL"): {
                //initialize form for manual entering the card data
                break;
            }
            case ("APPLE"): {
                // initialize Apple Pay form
                break;
            }
            case ("GOOGLE"): {
                //initialize Google Pay form
                break;
            }
            default:
                //initialize form for manual entering the card data
                break;
        }
    }

    public void printTypes() {
        logger.info("Supported card types:");
        for (cardType type : cardType.values()) {
            logger.info(type.name());
        }
    }

    private boolean PaymentProcess() {
        //here should be the process and after the sum is successfully paid, return true;
        return true;
    }

    public boolean isPaid() {
        if (PaymentProcess())
            return true;
        else
            return false;
    }
}
