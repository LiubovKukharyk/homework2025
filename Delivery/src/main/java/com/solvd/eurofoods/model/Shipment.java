package main.java.com.solvd.eurofoods.model;

import java.time.*;
import java.util.List;

public class Shipment {
	
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
    
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public Account getAddressee() {
		return addressee;
	}

	public void setAddressee(Account addressee) {
		this.addressee = addressee;
	}
	
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(LocalTime finishTime) {
		this.finishTime = finishTime;
	}
	
	public void formShipment() {
		this.equals();
		//then DB work with shipment data
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
			System.out.println("Check the shipment time info");
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
	public void printView() {
	    ShipmentView view = new ShipmentView(
	        "Active",
	        order.getBasket().getProducts().stream()
	            .map(Item::getName)
	            .toList(),
	        getTrackingNumber()
	    );

	    System.out.println("Here is anonymized status and contents of the order in this shipment.");
	    System.out.println("Status: " + view.status());
	    System.out.println("Tracking Number: " + view.trackingNumber());

	    System.out.print("Order contents: ");
	    String orderItems = view.order().stream()
	    	    .reduce((item1, item2) -> item1 + " | " + item2)
	    	    .get();
	    System.out.println(orderItems);
	}

    private String getOrderStatusString() {
    	
    	return "PENDING"; //demo value
    }

}
