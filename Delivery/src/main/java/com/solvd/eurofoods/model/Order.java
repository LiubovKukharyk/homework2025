package com.solvd.eurofoods.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.solvd.eurofoods.exceptions.OrderException;
import com.solvd.eurofoods.util.IStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Order implements IStore {

    private static final Logger logger = LoggerFactory.getLogger(Order.class);

    private Basket basket;
    private Account buyer;
    private boolean confirmed;
    private boolean paid;
    private String number;
    private LocalDate date;
    private LocalTime time;
    private String status;

    public Order(Basket basket, Account buyer, boolean confirmed, boolean paid,
                 String number, LocalDate date, LocalTime time, String status) {
        this.basket = basket;
        this.buyer = buyer;
        this.confirmed = confirmed;
        this.paid = paid;
        this.number = number;
        this.date = date;
        this.setTime(time);
        this.setStatus(status);
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Account getBuyer() {
        return buyer;
    }

    public void setBuyer(Account buyer) {
        this.buyer = buyer;
    }

    public boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void orderForm() {}

    public void showInfo(Order o) {}

    public void clearBasket() {}

    public void addItems(com.solvd.eurofoods.model.Item item, int value) {
        basket.addItem(item);
        item.setQuantity(value);
    }

    public void removeItem(com.solvd.eurofoods.model.Item item) {
        this.basket.removeItem(item);
        logger.info("{} is removed from the order", item.getName());
    }

    public void editItem() {
        int a = 0;
        int b = 0;
        this.setQuantity(a, b);
    }

    public void changeStatus(Order o) {
        try {
            if (!o.getConfirmed() || !o.isPaid()) {
                throw new OrderException("Can't change the status of unconfirmed order");
            }
            o.setStatus("Processed");
            logger.info("Order is being processed");
        } catch (OrderException e) {
            logger.error("Order status error {}", e.getMessage());
        }
    }

    private void setQuantity(int position, int quantity) {
        try {
            if (quantity < 0) {
                throw new OrderException("Quantity of the product can't be less than zero");
            }
            if (quantity == 0) {
                throw new OrderException("Warning: Product quantity is zero");
            }
            if (position < 0) {
                throw new IndexOutOfBoundsException();
            }
            this.basket.getProducts().get(position).setQuantity(quantity);
        } catch (OrderException e) {
            logger.error("Product quantity error: {}", e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            logger.error("Error: the product position is outside the boundaries");
        } finally {
            try {
                logger.info("Current quantity of this product in the order: {}",
                        this.basket.getProducts().get(position).getQuantity());
            } catch (IndexOutOfBoundsException e) {
                logger.error("Error accessing product quantity in finally block");
            }
        }
    }

    public void storageList() {
        logger.info("Here is a 'List of storage availability of the items that were "
        		+ "added to the basket'");
    }
    public List getItems() {
        return this.basket.getProducts();
    }
}
