package com.solvd.eurofoods.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    private String name;
    private Location contactInfo;
    private Storage storage;
    private String bic;
    private String inn;
    private String usreou;
    private String iban;

    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Shipment> shipments = new ArrayList<>();
    private ArrayList<Manager> managers = new ArrayList<>();
    private ArrayList<Courier> couriers = new ArrayList<>();
    private ArrayList<Account> customers = new ArrayList<>();

    public void employeeRatings() {}

    public void salaryBonuses() {}
}
