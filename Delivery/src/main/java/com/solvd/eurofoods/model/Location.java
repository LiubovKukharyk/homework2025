package main.java.com.solvd.eurofoods.model;

import main.java.com.solvd.eurofoods.util.ISend;

public class Location implements ISend {
	
	private String region;
	private String city;
	private String office;
	private String postomat;
	private String street;
	private String houseNumber;
	private String aptNumber;
	private String userchoice;

    public Location(String region, String city, String office,
            String postomat, String street, String houseNumber, String aptNumber,
            String userchoice) {
    	this.region = region;
    	this.city = city;
    	this.office = office;
    	this.postomat = postomat;
    	this.street = street;
    	this.houseNumber = houseNumber;
    	this.aptNumber = aptNumber;
    	this.userchoice = userchoice;
    }
	public String userchoice () {
		// implements getting the user's choice of delivery method
		return userchoice;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getPostomat() {
		return postomat;
	}

	public void setPostomat(String postomat) {
		this.postomat = postomat;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getAptNumber() {
		return aptNumber;
	}

	public void setAptNumber(String aptNumber) {
		this.aptNumber = aptNumber;
	};
	
	public void formContents (Account c) {

		if (this.userchoice == c.getServices(0)) {
			setRegion(new String());
			setCity(new String());
			setOffice(new String ());
			setPostomat(new String ());
		}
		if (userchoice == c.getServices(1)) {
			
		}
		if (userchoice == c.getServices(2)) {
			
		}
		if (userchoice == c.getServices(3)) {
			
		}
	}
	
	public void formFetch () { 
		
	}
	public void fieldsValidationCheck () {}

}


