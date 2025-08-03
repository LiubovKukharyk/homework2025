package main.java.com.solvd.eurofoods.util;

import main.java.com.solvd.eurofoods.model.Item;
import main.java.com.solvd.eurofoods.model.Order;

public interface ITake {
	
    public default void clear() {}
	public static void addItem(Order o, Item item) {}
	public static void removeItem(Order o, Item item) {}
	public default void storageList() {}

}
