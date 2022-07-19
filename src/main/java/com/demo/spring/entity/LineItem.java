package com.demo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ITEM")
public class LineItem {
	
	@Id
	@Column(name = "ITEMID")
	private int itemId;
	@Column(name = "ITEMNAME")
	private String itemName;
	@Column(name = "ITEMPRICE")
	private double itemPrice;

	@ManyToOne
	@JoinColumn(name = "ORDERID")
	@JsonIgnore
	private Order orders;
	
	public LineItem() {
		
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

//	public Order getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(Order orderId) {
//		this.orderId = orderId;
//	}
	
	

	
}
