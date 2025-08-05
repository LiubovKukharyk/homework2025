package com.solvd.eurofoods.model;

import java.util.ArrayList;
import java.util.List;

import com.solvd.eurofoods.exceptions.EmptyBasketException;
import com.solvd.eurofoods.exceptions.InvalidItemException;
import com.solvd.eurofoods.util.ITake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Basket implements ITake {

    private static final Logger logger = LoggerFactory.getLogger(Basket.class);
    private List<Item> products = new ArrayList<>();

    public List<Item> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Item> products) {
        this.products = products;
    }

    public void clear() {
        try {
            if (products.isEmpty()) {
                throw new EmptyBasketException("Basket is already empty.");
            }
            products.clear();
            logger.info("Basket was cleared.");
        } catch (EmptyBasketException e) {
            logger.error("Error clearing basket: {}", e.getMessage(), e);
        } finally {
            logger.info("Basket is cleaned.");
        }
    }

    public void addItem(Item item) {
        try {
            if (item == null || item.getName() == null || item.getName().isBlank()) {
                throw new InvalidItemException("Invalid product: name is missing.");
            }
            products.add(item);
            logger.info("Product added: {}", item.getName());
        } catch (InvalidItemException e) {
            logger.error("Product adding error: {}", e.getMessage(), e);
        } finally {
            logger.info("Maybe you want to add another product? Check our discounts!");
        }
    }

    public void removeItem(Item item) {
        try {
            if (!products.contains(item)) {
                throw new InvalidItemException("Unable to remove — no such product in the basket.");
            }
            products.remove(item);
            logger.info("Product removed: {}", item.getName());
        } catch (InvalidItemException e) {
            logger.error("Product removal error: {}", e.getMessage(), e);
        } finally {
            logger.info("Maybe you want to add another product? Check our discounts!");
        }
    }

    public void storageList() {
        logger.info("Products in the basket:");
        for (Item item : products) {
            logger.info(item.getName());
        }
    }
}
