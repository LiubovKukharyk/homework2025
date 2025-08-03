package main.java.com.solvd.eurofoods.model;

import main.java.com.solvd.eurofoods.exceptions.CategoryException;
import main.java.com.solvd.eurofoods.exceptions.InvalidCategoryComparisonException;
import main.java.com.solvd.eurofoods.exceptions.NullCategoryException;

public final class Category {

    private String name;
    private short id;
    private Category upper;

    private Category(short ID, String name, Category upper) {
        this.id = ID;
        this.name = name;
        this.upper = upper;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public Category getUpper() {
        return upper;
    }

    public void setUpper(Category c) throws CategoryException {
        if (c == null) {
            throw new NullCategoryException("Upper category cannot be null.");
        }

        try {
            if (this.equals(c)) {
                throw new InvalidCategoryComparisonException("A category cannot be set as its own upper.");
            }
            this.upper = c;
        } catch (CategoryException e) {
            System.err.println("Error in setUpper: " + e.getMessage());
            throw e;
        }
    }

    public boolean equals(Category other) throws CategoryException {
        try {
            if (other == null) {
                throw new NullCategoryException("Null category");
            }

            if (this.hashCode() == other.hashCode() && this.id == other.id) {
                return true;
            }
            return false;
        } catch (CategoryException e) {
            System.err.println("Error when checking the categories hierarchy: " + e.getMessage());
            throw e;
        } finally {
        }
    }

    public void add() {
    }

    public void remove() {
    }
}