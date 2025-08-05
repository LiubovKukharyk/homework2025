package com.solvd.eurofoods.model;

import java.util.List;

public record ShipmentView(String status, List<String> order, String trackingNumber) {

}
