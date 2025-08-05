package com.solvd.eurofoods.model;

import java.util.ArrayList;

public class Ratings {

	private static int[] ratings = new int[]{1, 2, 3, 4, 5};
	private int value;
	private float average;
	private ArrayList<Integer> scale = new ArrayList<Integer>();
	
    public Ratings(int value, float average) {
        this.value = value;
        this.average = average;
    }
	
	public static int[] getRatings() {
		return ratings;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public float getAverage() {
		return average;
	}
	
	public void setAverage(float average) {
		this.average = average;
	}
	
	public ArrayList<Integer> getScale() {
		return scale;
	}
	
	public void setScale(ArrayList<Integer> scale) {
		this.scale = scale;
	}
	
	public void courierRating (Courier c, Account u) {
	} 
	
	public void shipmentRating (Shipment s, Account u) {
	}

	public float averageRating() {
		return average;
	}

}
