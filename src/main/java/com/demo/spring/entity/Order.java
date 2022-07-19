package com.demo.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@Column(name = "ORDERID")
	private int orderId;
	@Column(name = "CUSTNAME")
	private String customerName;

	
	@OneToMany(fetch = FetchType.EAGER, cascade =CascadeType.ALL, mappedBy = "orders")
	//@JsonIgnore
	private List<LineItem> lineitem = new ArrayList<>();
	  
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "ADDRESSID")
	private ShippingAddress address;
	
	public Order() {
		
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<LineItem> getLineitem() {
		return lineitem;
	}

	public void setLineitem(List<LineItem> lineitem) {
		this.lineitem = lineitem;
	}

	public ShippingAddress getAddress() {
		return address;
	}

	public void setAddress(ShippingAddress address) {
		this.address = address;
	}

	
	
	
}
