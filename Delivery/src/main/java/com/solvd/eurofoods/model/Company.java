package main.java.com.solvd.eurofoods.model;

import java.util.ArrayList;

public class Company {
	private String name;
	private Location contactInfo;
	private Storage storage;
	private String bic;
	private String inn;
	private String usreou;
	private String iban;
	private ArrayList<Order> orders = new ArrayList<>();
	private ArrayList<Shipment> shipments = new ArrayList<>();
	private ArrayList<Manager> managers = new ArrayList<>();
	private ArrayList<Courier> couriers = new ArrayList<>();
	private ArrayList<Account> customers = new ArrayList<>();
	
	public Company(String name, Location contactInfo, Storage storage,
            String bic, String inn, String usreou, String iban) {
		this.name = name;
		this.contactInfo = contactInfo;
		this.storage = storage;
		this.bic = bic;
		this.inn = inn;
		this.usreou = usreou;
		this.iban = iban;

		this.orders = new ArrayList<>();
		this.shipments = new ArrayList<>();
		this.managers = new ArrayList<>();
		this.couriers = new ArrayList<>();
		this.customers = new ArrayList<>();
	}
 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(Location contactInfo) {
		this.contactInfo = contactInfo;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public ArrayList<Shipment> getShipments() {
		return shipments;
	}
	public void setShipments(ArrayList<Shipment> shipments) {
		this.shipments = shipments;
	}
	public ArrayList<Manager> getManagers() {
		return managers;
	}
	public void setManagers(ArrayList<Manager> managers) {
		this.managers = managers;
	}
	public ArrayList<Courier> getCouriers() {
		return couriers;
	}
	public void setCouriers(ArrayList<Courier> couriers) {
		this.couriers = couriers;
	}
	public ArrayList<Account> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Account> customers) {
		this.customers = customers;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getInn() {
		return inn;
	}
	public void setInn(String inn) {
		this.inn = inn;
	}
	public String getUsreou() {
		return usreou;
	}
	public void setUsreou(String usreou) {
		this.usreou = usreou;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	
	public void employeeRatings () {}
	public void salaryBonuses () {}

}
