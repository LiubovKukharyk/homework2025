package com.solvd.eurofoods.model;

import java.time.LocalDate;
import java.util.Map;
import com.solvd.eurofoods.exceptions.DiscountException;
import com.solvd.eurofoods.util.ISend;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Item implements ISend {

    @Builder.Default
    private ItemView view = null;
    private static final Logger logger = LoggerFactory.getLogger(Item.class);

    private String name;
    private int itemID;
    private short categoryID;
    private String description;
    private boolean inStock;
    private double price;
    private double newPrice;
    private LocalDate expiry;
    private Discount discount;
    private int quantity;

    public void setNewPrice(double newPrice) {
        try {
            this.newPrice = discountedPrice(discount);
        } catch (ArithmeticException | DiscountException e) {
        	logger.error("Error in calculation of discounted price ", e);
        }
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative: " + quantity);
        }
        this.quantity = quantity;
    }

    public void selectCategory() {}

    public void sortBy() {}

    public short getCategoryID() {
        return categoryID;
    }

    public void expirationNotice() {}

    public double discountedPrice(Discount d) throws ArithmeticException, DiscountException {
        newPrice = d.calculateNewPrice(price);
        return newPrice;
    }

    public void categoryCheck(Item item, short cat) {
        if (item.getCategoryID() != cat) {
            throw new IllegalArgumentException("No such category");
        }
    }

    @Override
    public void sending() {
        this.view = new ItemView(
            this.name,
            this.itemID,
            this.categoryID,
            this.description,
            this.inStock,
            this.price,
            this.newPrice,
            this.expiry,
            this.quantity
        );
        System.out.println("Current state snapshot of " + this.name + " is saved");
    }

    @Override
    public void returning() {
        System.out.println("Current state snapshot of " + this.name + ":");

        Map<String, Object> viewData = Map.of(
            "Name", view.name(),
            "ID", view.itemID(),
            "Category", view.categoryID(),
            "Description", view.description(),
            "In stock", view.inStock(),
            "Price", view.price(),
            "New Price", view.newPrice(),
            "Expiry", view.expiry(),
            "Quantity", view.quantity()
        );

        viewData.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
