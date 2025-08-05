package com.solvd.eurofoods.model;

import java.util.ArrayList;

import com.solvd.eurofoods.util.IStore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Courier extends Person implements IStore {

    private static final Logger logger = LogManager.getLogger(Courier.class);

    private ArrayList<Shipment> pending;
    private ArrayList<String> history;
    private Shipment current;
    private Ratings rated;
    private Vehicle vehicle;

    public Courier(String firstName, String lastName, String id, String email, String phone,
            ArrayList<Shipment> pending,
            ArrayList<String> history,
            Shipment current, Ratings rated, Vehicle vehicle) {
        super(firstName, lastName, id, email, phone);
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
        logger.info("All vehicle types: ");
        Vehicle.printVehicleTypes(type -> logger.info(" - {}", type));
        logger.info("Current vehicle type: {}", Vehicle.VehicleType.BYFOOT.getDisplayType());
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    


    public float getRating() {
        rated.averageRating();
        return rated.getAverage();
    }

    public void update(Shipment s) {}

    public void ShipmentReturn(Shipment s) {}

    public void SortingShipmentsBy() {}
}
