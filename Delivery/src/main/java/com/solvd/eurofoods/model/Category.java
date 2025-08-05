package com.solvd.eurofoods.model;

import com.solvd.eurofoods.exceptions.CategoryException;
import com.solvd.eurofoods.exceptions.InvalidCategoryComparisonException;
import com.solvd.eurofoods.exceptions.NullCategoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Category {

    private static final Logger logger = LoggerFactory.getLogger(Category.class);

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
            logger.error("Attempted to set null as upper category.");
            throw new NullCategoryException("Upper category cannot be null.");
        }

        try {
            if (this.equals(c)) {
                throw new InvalidCategoryComparisonException("A category cannot be set as its own upper.");
            }
            this.upper = c;
        } catch (CategoryException e) {
            logger.error("Error in setUpper: {}", e.getMessage(), e);
            throw e;
        }
    }

    public boolean equals(Category other) throws CategoryException {
        try {
            if (other == null) {
                throw new NullCategoryException("Null category");
            }

            return this.hashCode() == other.hashCode() && this.id == other.id;
        } catch (CategoryException e) {
            logger.error("Error when checking the categories hierarchy: {}", e.getMessage(), e);
            throw e;
        }
    }

    public void add() {
    }

    public void remove() {
    }
}
