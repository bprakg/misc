package com.prakash.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomerOrder {

	public CustomerOrder() {
	}
	@Id @GeneratedValue
	private int orderId;
	private int discount;
	private Date lastUpdate;
	private String shipmentInfo;
	private char satus;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getShipmentInfo() {
		return shipmentInfo;
	}
	public void setShipmentInfo(String shipmentInfo) {
		this.shipmentInfo = shipmentInfo;
	}
	public char getSatus() {
		return satus;
	}
	public void setSatus(char satus) {
		this.satus = satus;
	}
}
