package main.java.com.solvd.eurofoods.util;

import main.java.com.solvd.eurofoods.model.Item;

public interface IStore {

	default void sortedList() {}
	default void addItems(Item item) {} 
	default void removeItems(Item item) {} 
	default void itemEdit(Item item) {} 
}
