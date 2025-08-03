package main.java.com.solvd.eurofoods.model;

import java.util.ArrayList;
import java.util.Arrays;

import main.java.com.solvd.eurofoods.exceptions.AccountException;
import main.java.com.solvd.eurofoods.exceptions.DuplicateAccountException;
import main.java.com.solvd.eurofoods.exceptions.InvalidAccountDataException;

public class Account {

    private Person p;
    private Company c;
    private String firstName = p.getFirstName();
    private String lastName = p.getLastName();
    private String id;
    private String phone;
    private String email;
    private String password;
    private byte timesOrdered;
    private ArrayList<String> services = new ArrayList<>(Arrays.asList(
            "COURIER", "NOVAPOST", "UKRPOST", "MEEST"));
    private String delivery;
    private ArrayList<Order> history = new ArrayList<>();
    private ArrayList<Location> addresses = new ArrayList<>();

    public Account(String firstName, String lastName, String phone, String email, String id, 
    				String password, byte timesOrdered,
                   ArrayList<Order> history, ArrayList<Location> addresses, String delivery) {
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
    	this.phone = phone;
        this.id = id;
        this.password = password;
        this.timesOrdered = timesOrdered;
        this.email = email;
        this.history = history;
        this.addresses = addresses;
        this.delivery = delivery;
    }

    public Company getCompany() {
        return c;
    }

    public void setCompany(Company c) {
        this.c = c;
    }

    public Person getPerson() {
        return p;
    }

    public void setPerson(Person p) {
        this.p = p;
    }

    public void setServices(String s) {
        services.add(s);
    }

    public String getServices(int j) {
        return services.get(j);
    }

    public void getServices() {
        for (String service : services) {
            System.out.println(service);
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getTimesOrdered() {
        return timesOrdered;
    }

    public void setTimesOrdered(byte timesOrdered) {
        this.timesOrdered = timesOrdered;
    }

    public void getOrdersHistory() {
        if (c != null) {
            System.out.println("Hello, " + c.getName() + "! Your order history:");
        } else if (p != null) {
            System.out.println("Hello, " + p.getFirstName() + " " + p.getLastName() + "! Your order history:");
        }
    	System.out.println("Client | Confirmation | Payment status | Order # | Date |"
         		+ "Time | Order status");
        String allOrders = history.stream()
                .map(order -> new Order(
                    null, //decided not to show the basket in the orders history
                    order.getBuyer(),
                    order.getConfirmed(),
                    order.isPaid(),
                    order.getNumber(),
                    order.getDate(),
                    order.getTime(),
                    order.getStatus()))
                .map(Order::toString)
                .reduce((o1, o2) -> o1 + " | " + o2)
                .orElse("No orders yet");
      
        	System.out.println(allOrders);
        }
    

    public void setHistory(ArrayList<Order> history) {
        this.history = history;
    }

    public ArrayList<Location> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Location> addresses) {
        this.addresses = addresses;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setPreferredDeliveryMethod(int i) {
        delivery = services.get(i);
    }

    public boolean clientType() {
        boolean type = false;
        return type;
    }

    public void checkCreds() {
    }

    public void addOrder() {
    }

    public void manageAddresses() {
    }

    public void discardOrder() {
    }

    public void editProfile() {
    }

    public void currentOrderView() {
    }

    public void shipmentManage() {
    }

    public void sortingOrdersBy() {
    }

    public void sortingShipmentsBy() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void compareContactInfo(Account other) throws AccountException {
        if (this.email != null && this.email.equals(other.getEmail())
                && this.phone != null && this.phone.equals(other.getPhone())) {
            throw new DuplicateAccountException(
            		"An account with the same email and phone already exists.");
        }
    }

    public void validate() throws InvalidAccountDataException {
        if (email == null || email.isBlank()
                || phone == null || phone.isBlank()
                || password == null || password.length() < 6) {
            throw new InvalidAccountDataException(
            		"Email, phone, and password must be valid and not empty.");
        }
    }
}
