package com.solvd.eurofoods.model;

import java.util.ArrayList;

import com.solvd.eurofoods.util.IStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Manager extends Person implements IStore {

    private static final Logger logger = LoggerFactory.getLogger(Manager.class);

    private ArrayList<Order> currentOrders;
    private ArrayList<Shipment> currentShipments;
    private ArrayList<Order> ordersHistory;
    private Ratings rated;

    public Manager(String firstName, String lastName, String id,
                   ArrayList<Order> ordersHistory,
                   ArrayList<Order> currentOrders,
                   ArrayList<Shipment> currentShipments, Ratings rated) {
        super(firstName, lastName, id, null, null);
        this.ordersHistory = ordersHistory;
        this.currentOrders = currentOrders;
        this.currentShipments = currentShipments;
        this.rated = rated;
    }

    @SuppressWarnings("unused")
	private void setOrdersHistory(ArrayList<Order> ordersHistory) {
        this.ordersHistory = ordersHistory;
    }

    public ArrayList<Order> getCurrentOrders() {
        return currentOrders;
    }

    public void setCurrentOrders(ArrayList<Order> currentOrders) {
        this.currentOrders = currentOrders;
    }

    public ArrayList<Shipment> getCurrentShipments() {
        return currentShipments;
    }

    public void setCurrentShipments(ArrayList<Shipment> currentShipments) {
        this.currentShipments = currentShipments;
    }

    public ArrayList<Order> getOrdersHistory() {
        logger.info("Manager {} {} orders to process", this.getFirstName(), this.getLastName());
        if (ordersHistory != null) {
            for (Order order : ordersHistory) {
                logger.info(order.toString());
            }
        } else {
            logger.warn("Orders history is null");
        }
        return ordersHistory;
    }

    public Ratings getRated() {
        return rated;
    }

    public void setRated(Ratings rated) {
        this.rated = rated;
    }

    public void currentOrderView() {}
    public void currentShipmentView() {}
    protected void shipmentManage(Shipment s) {}
    protected void orderManage(Order o) {}
    public void SortingOrdersBy() {}
    public void SortingShipmentsBy() {}
    public void itemEdit(Item item) {}
    public void addItems(Item item, int quantity) {}
    public void removeItems(Item item, int quantity) {}

    public void storageList() {
        logger.info("Here is an 'Items added, but then removed by customer' list");
    }

    public float getRating() {
        rated.averageRating();
        return rated.getAverage();
    }
}
