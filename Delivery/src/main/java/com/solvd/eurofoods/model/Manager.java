package main.java.com.solvd.eurofoods.model;

import java.util.ArrayList;

import main.java.com.solvd.eurofoods.util.IStore;

public class Manager extends Person implements IStore {
	
	private ArrayList<Order> currentOrders;
	private ArrayList<Shipment> currentShipments;
	private Ratings rated;
	
    public Manager(String firstName, String lastName, String id,
            ArrayList<Order> ordersHistory,
            ArrayList<Order> currentOrders,
            ArrayList<Shipment> currentShipments, Ratings rated) {
    	this.setFirstName(firstName);
    	this.setLastName(lastName);
    	this.setId(id);
    	this.setOrdersHistory(ordersHistory);
    	this.currentOrders = currentOrders;
    	this.currentShipments = currentShipments;
    	this.setRated(rated);
    }
    
	private void setOrdersHistory(ArrayList<Order> ordersHistory) {
		// TODO Auto-generated method stub
		
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
		System.out.println("Manager "+this.getFirstName()+" "+this.getLastName()+" orders to process");
		ArrayList <Order> h = this.getOrdersHistory();
		for (int i = 0; i < h.size(); i++)
		{
			System.out.println(h.get(i));
		}
		return null;
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
	public void SortingShipmentsBy() {
		//implementation for manager, full and with extended statistics
	}
	public void itemEdit(Item item) {}
	public void addItems(Item item, int quantity) {}
	public void removeItems(Item item, int quantity) {}
	public void storageList() {
		System.out.println("Here is an 'Items added, but then removed by customer' list");
	}
	public float getRating() {
		rated.averageRating();
		return rated.getAverage();
	}
}
