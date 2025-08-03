package main.java.com.solvd.eurofoods.model;

import java.util.LinkedList;
import java.util.List;

import main.java.com.solvd.eurofoods.util.IStore;

public class Storage implements IStore {
	
	private LinkedList<Item> storage = new LinkedList<>();
	
	public void getStorage() {
		for (int i=0; i<storage.size(); i++)
		System.out.println(storage.get(i).getName());
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
			Item item = storage.get(index);
			
			if (storage.size() <= index) {
				throw new ArrayIndexOutOfBoundsException("The position of the product '" 
						+ item.getName() + "' is out of the storage size boundaries");
			}
			
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
	            System.out.println(item.getName());
	        }
	    }
	}
	
}
