package main.java.com.solvd.eurofoods.model;

import java.util.Scanner;

import main.java.com.solvd.eurofoods.util.IComment;

public class Feedback implements IComment {
	
	private String body;
	public final int stars[]= {1,2,3,4,5};
	public String toString(String s) {
		return null;
	}
	public String getBody() {
	    return body;
	}
	public String hashcode() {
		return null;
	}
	public String equals(String hash) {
		return null;
	}
	public String userName() {
		return null;
	}
	@Override
	public void commentPost() {

	    System.out.print("Enter your comment: ");
	    try (Scanner scanner = new Scanner(System.in)) {
	        this.body = scanner.nextLine();
	    }
	}
	@Override
	public int chooseRating() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String moderation() {
		// TODO Auto-generated method stub
		return null;
	}

}
