package main.java.com.solvd.eurofoods.model;

import java.util.ArrayList;
import java.util.List;

import main.java.com.solvd.eurofoods.exceptions.EmptyBasketException;
import main.java.com.solvd.eurofoods.exceptions.InvalidItemException;
import main.java.com.solvd.eurofoods.util.ITake;

public class Basket implements ITake {

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
            System.out.println("Basket is already empty.");
        } catch (EmptyBasketException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Basket is cleaned");
        }
    }

    public void addItem(Item item) {
        try {
            if (item == null || item.getName() == null || item.getName().isBlank()) {
                throw new InvalidItemException("Invalid product: name is missing.");
            }
            products.add(item);
            System.out.println("Product is added: " + item.getName());
        } catch (InvalidItemException e) {
            System.err.println("Product adding error: " + e.getMessage());
        } finally {
            System.out.println("Maybe you want to add another product? Check our discounts!");
            
        }
    }

    public void removeItem(Item item) {
        try {
            if (!products.contains(item)) {
                throw new InvalidItemException("Unable to remove "
                		+ "no such product in the basket.");
            }
            products.remove(item);
            System.out.println("The product is removed from the basket " + item.getName());
        } catch (InvalidItemException e) {
            System.err.println("Product removal error: " + e.getMessage());
        } finally {
            System.out.println("Maybe you want to add another product? Check our discounts!");
            
        }
    }

    public void storageList() {
        System.out.println("Products in the basket: ");
        for (Item item : products) {
            System.out.println(item.getName());
        }
    }
}
