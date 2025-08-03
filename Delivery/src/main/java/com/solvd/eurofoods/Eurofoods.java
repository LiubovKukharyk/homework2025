package main.java.com.solvd.eurofoods;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import main.java.com.solvd.eurofoods.exceptions.DiscountException;
import main.java.com.solvd.eurofoods.model.Account;
import main.java.com.solvd.eurofoods.model.Basket;
import main.java.com.solvd.eurofoods.model.Company;
import main.java.com.solvd.eurofoods.model.Courier;
import main.java.com.solvd.eurofoods.model.Discount;
import main.java.com.solvd.eurofoods.model.Item;
import main.java.com.solvd.eurofoods.model.Location;
import main.java.com.solvd.eurofoods.model.Manager;
import main.java.com.solvd.eurofoods.model.Order;
import main.java.com.solvd.eurofoods.model.Payment;
import main.java.com.solvd.eurofoods.model.Ratings;
import main.java.com.solvd.eurofoods.model.Shipment;
import main.java.com.solvd.eurofoods.model.StatusMessage;
import main.java.com.solvd.eurofoods.model.Storage;
import main.java.com.solvd.eurofoods.model.Vehicle;

public class Eurofoods {
    
	static
	{
		System.out.println("Hello!");
		System.out.println(LocalDate.now()+" "+LocalTime.now());
	}

	public static void main(String[] args) throws ArithmeticException, DiscountException {
		
		Storage a = new Storage();
		Location office = new Location(
	            "Kyivska", "Kyiv", "Office #32, third floor",
	            "Nova Post #12034", "Beresteyska","9", null,
	            null);
		//using Reflection
		try {
		    Class<?> companyClass = Class.forName("com.solvd.eurofoods.account.Company");
		    
		    java.lang.reflect.Constructor<?> constructor = companyClass.getDeclaredConstructor(
		        String.class, Location.class, Storage.class,
		        String.class, String.class, String.class, String.class);
		    
		    Company eurofoods = (Company) constructor.newInstance(
		        "Eurofoods", office, a,
		        "03920", "39483920022", "333888", "UA08000393939383848848");

		} catch (Exception e) {
		    System.err.println("Company data filling error" + e.getMessage());
		}
		Manager m = new Manager ("Elena", "Kushch", "00938",
				new ArrayList<>(),
				new ArrayList<>(),
				new ArrayList<>(), new Ratings (5,(float) 4.8));
    	Account currentCustomer = new Account ("Maxim", "Belenko","+3802742238432", 
    					"i32h99832@gmail.com", "32223","Qwerty1@", 
    			   		(byte) 4, new ArrayList<>(), new ArrayList<>(), "UKRPOST");
    	Basket b = new Basket();
    	Discount seasonal = new Discount("Summer", "Enjoy 20% less at summer!", 20);
    	Item buldakLimeSmall = new Item("Buldak Habanero Lime small",(short) 239, 
    			        (short) 8, "These noodles are the definition of hot. But the "
    			        + "real magic is in the combination of fiery habanero "
    					+ "with the refreshing taste of lime – a flavor explosion "
    					+ "like you've never experienced before! Why you should try it: "
    					+ "Unique flavor combo: Spicy habanero + refreshing "
    					+ "lime = just perfect!", true,
    				    125.0, 125.0, LocalDate.of(2026, 6, 01), seasonal, 3);

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
    	Shipment s = new Shipment(
                null, null, null, order, address, currentCustomer, "00000291", m,
                LocalDate.now(), LocalTime.now(), null, null, false);
    	Courier courier = new Courier ("Alexandr", "Plisko", "00492", 
    			"39dj39@gmail.com", "+382939292929",
    			new ArrayList<>(),
    			new ArrayList<>(),
                s, new Ratings (4,(float) 4.5), v);
    	courier.getPending().add(s);
    	courier.getHistory().add(s.getTrackingNumber());
    	StatusMessage trackstart = new StatusMessage(currentCustomer, order, 
    			s, 239249, 93293);
    	trackstart.sendEmail();
    	trackstart.sendPush();
    	}
    	
    }
	

}
