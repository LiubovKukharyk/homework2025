package com.solvd.eurofoods.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import com.solvd.eurofoods.exceptions.DiscountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Eurofoods {
	
	private static final Logger logger = LoggerFactory.getLogger(Eurofoods.class);
	
	static
	{
		System.out.println("Hello!");
		System.out.println(LocalDate.now()+" "+LocalTime.now());
	}

	public static void main(String[] args) throws ArithmeticException, DiscountException {
		
		Storage storage = new Storage();
		Location office = new Location(
	            "Kyivska", "Kyiv", "Office #32, third floor",
	            "Nova Post #12034", "Beresteyska","9", null,
	            null);
		try {
		    Class<?> companyClass = Class.forName("com.solvd.eurofoods.account.Company");
		    
		    java.lang.reflect.Constructor<?> constructor = companyClass.getDeclaredConstructor(
		        String.class, Location.class, Storage.class,
		        String.class, String.class, String.class, String.class);
		    
		    Company eurofoods = (Company) constructor.newInstance(
		        "Eurofoods", office, storage,
		        "03920", "39483920022", "333888", "UA08000393939383848848");

		} catch (Exception e) {
			logger.error("Company data filling error", e);
		}
		Manager m = new Manager ("Elena", "Kushch", "00938",
				new ArrayList<>(),
				new ArrayList<>(),
				new ArrayList<>(), new Ratings (5,(float) 4.8));
		Person person = new Person(
			    "Maxim",
			    "Belenko",
			    "32223",
			    "i32h99832@gmail.com",
			    "+3802742238432"
			);
		Account currentCustomer = new Account(
			    person,
			    "+3802742238432",
			    "i32h99832@gmail.com",
			    "32223",
			    "Qwerty1@",
			    (byte) 4,
			    new ArrayList<>(),
			    new ArrayList<>(),
			    "UKRPOST"
			);
    	Basket b = new Basket();
    	Discount seasonal = new Discount("Summer", "Enjoy 20% less at summer!", 20);
    	Item buldakLimeSmall = Item.builder()
    		    .name("Buldak Habanero Lime small")
    		    .itemID(239)
    		    .categoryID((short) 8)
    		    .description("These noodles are the definition of hot...")
    		    .inStock(true)
    		    .price(125.0)
    		    .newPrice(125.0)
    		    .expiry(LocalDate.of(2026, 6, 1))
    		    .discount(seasonal)
    		    .quantity(3)
    		    .build();

    	Order order = new Order(b, currentCustomer, 
    		 true, false, "00039232383", 
    			LocalDate.now(),LocalTime.now(), "Pending");
    	buldakLimeSmall.discountedPrice(seasonal);
    	order.addItems(buldakLimeSmall);
    	order.setNumber("00000329");
    	
    	currentCustomer.setPreferredDeliveryMethod(0);
    	Location address = new Location(
    			"Zhytomyrska", "Ovruch", null,
                null, "Shevchenka", "29", "18",
                "UKRPOST");
    	address.formContents(currentCustomer);
    	Payment p = new Payment();
    	Vehicle v = new Vehicle();
    	
    	if (p.isPaid()) {
    	m.getCurrentOrders().add(order);
    	Shipment shipment = new Shipment(
                null, null, null, order, address, currentCustomer, "00000291", m,
                LocalDate.now(), LocalTime.now(), null, null, false);
    	Courier courier = new Courier ("Alexandr", "Plisko", "00492", 
    			"39dj39@gmail.com", "+382939292929",
    			new ArrayList<>(),
    			new ArrayList<>(),
                shipment, new Ratings (4,(float) 4.5), v);
    	courier.getPending().add(shipment);
    	courier.getHistory().add(shipment.getTrackingNumber());
    	StatusMessage trackstart = new StatusMessage(currentCustomer, order, 
    			shipment, 239249, 93293);
    	trackstart.sendEmail();
    	trackstart.sendPush();
    	}
    	
    }
	

}
