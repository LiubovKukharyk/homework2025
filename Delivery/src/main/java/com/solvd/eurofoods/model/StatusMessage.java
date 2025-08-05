package com.solvd.eurofoods.model;

public class StatusMessage {

	private Account receiver;
	private Order orderInfo;
	private Shipment shipmentInfo;
	private int mailID;
	private int pushID;
	
	public StatusMessage(Account receiver, Order orderInfo, 
			Shipment shipmentInfo, int mailID, int pushID) {
		
		this.receiver = receiver;
		this.orderInfo = orderInfo;
		this.shipmentInfo = shipmentInfo;
		this.mailID = mailID;
		this.pushID = pushID;
		
	}
	private StatusMessage(){
	}
	
	public Account getReceiver() {
		return receiver;
	}
	
	public void setReceiver(Account receiver) {
		this.receiver = receiver;
	}
	
	public Order getOrderInfo() {
		return orderInfo;
	}
	
	public void setOrderInfo(Order orderInfo) {
		this.orderInfo = orderInfo;
	}
	
	public Shipment getShipmentInfo() {
		return shipmentInfo;
	}
	
	public void setShipmentInfo(Shipment shipmentInfo) {
		this.shipmentInfo = shipmentInfo;
	}

	public int getMailID() {
		return mailID;
	}

	public void setMailID(int mailID) {
		this.mailID = mailID;
	}

	public int getPushID() {
		return pushID;
	}

	public void setPushID(int pushID) {
		this.pushID = pushID;
	}
	
	public void sendEmail() {};
	public void sendPush() {};
	
	public String toString(StatusMessage m) {
		// there should be the code of text output for the whole status message
		m = new StatusMessage();
		String statusSummary=m.toString();
		return statusSummary;
	}
}
