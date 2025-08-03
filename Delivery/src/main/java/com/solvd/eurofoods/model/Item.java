package main.java.com.solvd.eurofoods.model;

import java.time.LocalDate;
import java.util.Map;

import main.java.com.solvd.eurofoods.exceptions.DiscountException;
import main.java.com.solvd.eurofoods.util.ISend;

public class Item implements ISend {
	
	private ItemView view;
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
	public Item(String name, int itemID, short categoryID, String description, boolean inStock,
            double price, double newPrice, LocalDate expiry,
            Discount discount, int quantity) {
    this.name = name;
    this.itemID = itemID;
    this.categoryID = categoryID;
    this.description = description;
    this.inStock = inStock;
    this.price = price;
    this.newPrice = newPrice;
    this.expiry = expiry;
    this.discount = discount;
    this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public short getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(short categoryID) {
		this.categoryID = categoryID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(double newPrice) {
		try {
			this.newPrice = discountedPrice(discount);
		} catch (ArithmeticException | DiscountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public LocalDate getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("Quantity cannot be negative: " + quantity);
		}
		this.quantity = quantity;
	}

	public void selectCategory() {};
	public void sortBy() {};
	public void expirationNotice() {};
	public double discountedPrice(Discount d) throws ArithmeticException, DiscountException {
		newPrice=d.calculateNewPrice(price);
		return newPrice;
	}
	
	public void categoryCheck(Item item, short cat) {
		
		if (item.getCategoryID() != cat)
		{
			throw new IllegalArgumentException ("No such category");
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
        System.out.println("Current state snapshot of "+this.name+" is saved");
    }
	
	@Override
	public void returning() {
	    System.out.println("Current state snapshot of "+this.name+":");

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
