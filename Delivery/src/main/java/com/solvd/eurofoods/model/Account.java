package com.solvd.eurofoods.model;

import java.util.ArrayList;
import java.util.Arrays;

import com.solvd.eurofoods.exceptions.AccountException;
import com.solvd.eurofoods.exceptions.DuplicateAccountException;
import com.solvd.eurofoods.exceptions.InvalidAccountDataException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Account {

    private static final Logger logger = LoggerFactory.getLogger(Account.class);
    private static final Logger ORDER_LOGGER = LoggerFactory.getLogger("com.solvd.eurofoods.order");

    private Person person; 
    private Company company;
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

    public Account(Person person, String phone, String email, String id,
                   String password, byte timesOrdered,
                   ArrayList<Order> history, ArrayList<Location> addresses, String delivery) {
        this.person = person;
        this.phone = phone;
        this.id = id;
        this.password = password;
        this.timesOrdered = timesOrdered;
        this.email = email;
        this.history = history;
        this.addresses = addresses;
        this.delivery = delivery;
    }

    public void getOrdersHistory() {
        try {
            StringBuilder header = new StringBuilder();
            if (company != null) {
                header.append("Hello, ").append(company.getName()).append("! Your "
                		+ "order history:\n");
            } else if (person != null) {
                header.append("Hello, ").append(person.getFirstName()).append(" ")
                .append(person.getLastName()).append("! Your order history:\n");
            }
            header.append("Client | Confirmation | Payment status | Order # | Date |"
            		+ " Time | Order status");

            String allOrders = history.stream()
                    .map(order -> new Order(
                            null,
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

            String fullLog = header + "\n" + allOrders;
            System.out.println(fullLog);
            ORDER_LOGGER.info(fullLog);

        } catch (Exception e) {
            logger.error("Failed to get orders history", e);
        }
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company c) {
        this.company = c;
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
        try {
            if (this.email != null && this.email.equals(other.getEmail())
                    && this.phone != null && this.phone.equals(other.getPhone())) {
                throw new DuplicateAccountException(
                        "An account with the same email and phone already exists.");
            }
        } catch (DuplicateAccountException e) {
            logger.error("Duplicate account detected", e);
            throw e;
        }
    }

    public void validate() throws InvalidAccountDataException {
        try {
            if (email == null || email.isBlank()
                    || phone == null || phone.isBlank()
                    || password == null || password.length() < 6) {
                throw new InvalidAccountDataException(
                        "Email, phone, and password must be valid and not empty.");
            }
        } catch (InvalidAccountDataException e) {
            logger.error("Account validation failed", e);
            throw e;
        }
    }
}
