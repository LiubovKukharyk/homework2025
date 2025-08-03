package main.java.com.solvd.eurofoods.model;

import java.util.ArrayList;

import main.java.com.solvd.eurofoods.util.IStore;

import java.util.stream.Collectors;

public class Courier extends Person implements IStore {

    private ArrayList<Shipment> pending;
    private ArrayList<String> history;
    private Shipment current;
    private Ratings rated;
    private Vehicle vehicle;

    public Courier (String firstName, String lastName, String id, String email, String phone,
                   ArrayList<Shipment> pending,
                   ArrayList<String> history,
                   Shipment current, Ratings rated, Vehicle vehicle) {
        this.getFirstName();
        this.getLastName();
        this.getId();        
        this.getEmail();
        this.getPhone();
        this.pending = pending;
        this.history = history;
        this.current = current;
        this.rated = rated;
        this.setVehicle(vehicle);
    }

	public ArrayList<Shipment> getPending() {
        return pending;
    }

    public void setPending(ArrayList<Shipment> pending) {
        this.pending = pending;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }
    
	public ArrayList<String> getOrdersHistory() {
		return history;
		// TODO Auto-generated method stub	
	}

    public Shipment getCurrent() {
        return current;
    }

    public void setCurrent(Shipment current) {
        this.current = current;
    }

    public Ratings getRated() {
        return rated;
    }

    public void setRated(Ratings rated) {
        this.rated = rated;
    }
    
	public void getVehicle() {
		System.out.println("All vehicle types: ");
		Vehicle.printVehicleTypes(type -> System.out.println(" - " + type));
		System.out.println("Current vehicle type: " 
		+ Vehicle.VehicleType.BYFOOT.getDisplayType());
	}

	public void setVehicle(Vehicle vehicle) {
		
		this.vehicle = vehicle;
	}

    public float getRating() {
        rated.averageRating();
        return rated.getAverage();
    }

    public void update(Shipment s) {}
        // entering the updated information and/or status of shipment
    public void ShipmentReturn(Shipment s) {}
        // moving the shipment to returned if not delivered
	public void SortingShipmentsBy() {
		//implementation for courier, simplified
	}
 
}
