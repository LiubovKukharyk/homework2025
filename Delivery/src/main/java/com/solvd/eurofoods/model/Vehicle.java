package com.solvd.eurofoods.model;

import java.util.Arrays;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vehicle {

    private static final Logger logger = LoggerFactory.getLogger(Vehicle.class);

    private String regNumber;
    private VehicleType type;

    public void showInfo() {
        logger.info("Vehicle Reg Number: {}", regNumber);
        logger.info("Vehicle Type: {}", (type != null ? type.getDisplayType() : "Unknown"));
    }

    public void registration() {
        
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
        Arrays.stream(VehicleType.values())
              .map(VehicleType::getDisplayType)
              .forEach(printer);
    }
}
