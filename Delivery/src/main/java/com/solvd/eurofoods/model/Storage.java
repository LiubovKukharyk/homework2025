package com.solvd.eurofoods.model;

import java.util.LinkedList;
import java.util.List;

import com.solvd.eurofoods.util.IStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Storage implements IStore {
    
    private static final Logger logger = LoggerFactory.getLogger(Storage.class);

    private LinkedList<Item> storage = new LinkedList<>();
    
    public void getStorage() {
        for (int i = 0; i < storage.size(); i++) {
            logger.info(storage.get(i).getName());
        }
    }
    
    public void setStorage(LinkedList<Item> storage) {
        this.storage = storage;
    } 
    
    public void addItems(List<Item> items) {
        for (Item item : items) {
            storage.add(item);
        }
    }
    
    public void addItems(Item item, int index) {
        storage.add(index, item);
    }
    
    public void removeItems(int index) {
        try {
            if (storage.size() <= index) {
                throw new ArrayIndexOutOfBoundsException("The position of the product at index " 
                        + index + " is out of the storage size boundaries");
            }
            Item item = storage.get(index);
            storage.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }
    }
    
    public void removeItems(short categoryID) {
        storage.removeIf(item -> item.getCategoryID() == categoryID);
    }
    
    public void showSearchedItems(String word) {
        String normalized = word.toLowerCase();
        for (Item item : storage) {
            if (item.getName().toLowerCase().contains(normalized) || 
                item.getDescription().toLowerCase().contains(normalized)) {
                logger.info(item.getName());
            }
        }
    }
    
}
