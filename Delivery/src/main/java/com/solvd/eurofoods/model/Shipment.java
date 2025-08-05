package com.solvd.eurofoods.model;

import java.time.*;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Shipment {
    
    private static final Logger logger = LoggerFactory.getLogger(Shipment.class);

    private static enum status {
        PENDING,
        PROCESSING,
        SENT,
        RETURNED,
        DONE
    };
    
    private String firstName;
    private String lastName;
    private String phone;
    private Order order;
    private Location destination;
    private Account addressee;
    private String trackingNumber;
    private Manager manager;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDate finishDate;
    private LocalTime finishTime;
    private boolean isReturned;
    
    public Shipment (String firstName, String lastName, String phone, Order order, 
            Location destination, Account addressee,
            String trackingNumber, Manager manager,
            LocalDate startDate, LocalTime startTime,
            LocalDate finishDate, LocalTime finishTime, boolean isReturned) {
        this.order = order;
        this.destination = destination;
        this.addressee = addressee;
        this.trackingNumber = trackingNumber;
        this.manager = manager;
        this.startDate = startDate;
        this.startTime = startTime;
        this.finishDate = finishDate;
        this.finishTime = finishTime;
        this.isReturned = isReturned;
    }
    
    // Getters and setters omitted for brevity (unchanged)
    
    public void formShipment() {
        this.equals();
        // then DB work with shipment data
    };
    public void AssignManager() {}
    public void statusSummary() {}
    public void changeStatus() {}
    public void changeDestination() {}
    public void getReturnedShipments () {}
    
    public static int hashcode() {
        String temp = java.time.LocalDateTime.now().toString().strip();
        return temp.hashCode();
    }
    
    private void equals() {
        if (this.startDate == this.finishDate && this.startTime == this.finishTime)
        {
            logger.info("Check the shipment time info");
        }
    }
    public void returning() {}
    public boolean isReturned() {
        return isReturned;
    }
    public void setReturned(boolean isReturned) {
        this.isReturned = isReturned;
    }
    public ShipmentView makeView() {

        List<String> orderItems;
        if (order != null) {
            orderItems = order.getItems();
        } else {
            orderItems = List.of(); 
        }

        return new ShipmentView(
            getOrderStatusString(),
            orderItems,
            trackingNumber);
    }
    
    public String getTrackingNumber () {
    	return this.trackingNumber; }
    
    
    public void printView() {
        ShipmentView view = new ShipmentView(
            "Active",
            order.getBasket().getProducts().stream()
                .map(Item::getName)
                .toList(),
            getTrackingNumber()
        );

        logger.info("Here is anonymized status and contents of the order in this shipment.");
        logger.info("Status: {}", view.status());
        logger.info("Tracking Number: {}", view.trackingNumber());

        String orderItems = view.order().stream()
                .reduce((item1, item2) -> item1 + " | " + item2)
                .orElse("");
        logger.info("Order contents: {}", orderItems);
    }

    private String getOrderStatusString() {
        
        return "PENDING"; //demo value
    }

}
