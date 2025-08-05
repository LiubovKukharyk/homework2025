package com.solvd.eurofoods.util;

import com.solvd.eurofoods.model.Item;
import com.solvd.eurofoods.model.Order;

public interface ITake {
	
    public default void clear() {}
	public static void addItem(Order o, Item item) {}
	public static void removeItem(Order o, Item item) {}
	public default void storageList() {}

}
