package main.java.com.solvd.eurofoods.model;

import java.util.Arrays;
import java.util.function.Consumer;

public class Vehicle {

    private String regNumber;
    private VehicleType type;

    public void showInfo() {
        System.out.println("Vehicle Reg Number: " + regNumber);
        System.out.println("Vehicle Type: " + (type != null ? type.getDisplayType() : "Unknown"));
    }

    public void registration() {
        // Registration logic
    }

    public String getNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public enum VehicleType {
        BIKE("Bike"),
        MOTORBIKE("Motorbike"),
        CAR("Car"),
        VAN("Van"),
        SCOOTER("Scooter"),
        BYFOOT("By foot");

        private final String displayType;

        VehicleType(String displayType) {
            this.displayType = displayType;
        }

        public String getDisplayType() {
            return displayType;
        }
    }
    public static void printVehicleTypes(Consumer<String> printer) {
    	
    	Arrays.stream(VehicleType.values()).map(VehicleType::getDisplayType)
    	.forEach(printer);
    }
}
