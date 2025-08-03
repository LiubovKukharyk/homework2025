package main.java.com.solvd.eurofoods.model;

import java.time.LocalDate;

public record ItemView(
        String name,
        int itemID,
        short categoryID,
        String description,
        boolean inStock,
        double price,
        double newPrice,
        LocalDate expiry,
        int quantity
) {}