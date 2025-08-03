package com.solvd.linkedlist;

import java.util.Scanner;

public class Main {
	
	private static int readIndex(Scanner scanner) {
	    try {
	        String input = scanner.nextLine();
	        return Integer.parseInt(input);
	    } catch (NumberFormatException e) {
	        System.out.println("Invalid input: index must be a number.");
	        return -1;
	    }
	}
	
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Create the linked list.");
        
        while (true) {
            System.out.print("Enter an element: ");
            String input = scanner.nextLine();
            list.add(input);

            System.out.print("Add another element? (y = yes, any other input = no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("y")) break;
        }

        System.out.println("\nList is created. Available commands: add, get, set, remove, contains, size, print, exit");

        while (true) {
            System.out.print("\nEnter the command: ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
            
                case "add":
                    System.out.print("Enter element to add: ");
                    list.add(scanner.nextLine());
                    break;

                case "get":
                    System.out.print("Enter index: ");
                    int getIndex = readIndex(scanner);
                    if (getIndex != -1) {
                        try {
                            System.out.println("Element at index " + getIndex + ": " + list.get(getIndex));
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Invalid index.");
                        }
                    }
                    break;

                case "set":
                    System.out.print("Enter index: ");
                    int setIndex = readIndex(scanner);
                    if (setIndex != -1) {
                        System.out.print("Enter new value: ");
                        String newValue = scanner.nextLine();
                        try {
                            list.set(setIndex, newValue);
                            System.out.println("Element at index " + setIndex + " updated.");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Invalid index.");
                        }
                    }
                    break;

                case "remove":
                    System.out.print("Enter index: ");
                    int removeIndex = readIndex(scanner);
                    if (removeIndex != -1) {
                        try {
                            String removed = list.remove(removeIndex);
                            System.out.println("Removed: " + removed);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Invalid index.");
                        }
                    }
                    break;


                case "contains":
                	System.out.print("Enter character to search in list elements: ");
                	char ch = scanner.nextLine().charAt(0);
                	boolean found = list.containsChar(ch);
                	if (!found) {
                	    System.out.println("No elements contain '" + ch + "'.");
                	}
                    break;

                case "size":
                    System.out.println("Size of list: " + list.size());
                    break;

                case "print":
                    System.out.println("List contents:");
                    for (String s : list) {
                        System.out.println("- " + s);
                    }
                    break;

                case "exit":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown method");
            }
        }
    }
}
