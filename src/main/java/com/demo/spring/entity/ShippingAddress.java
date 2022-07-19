package com.demo.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SHIPPINGADDRESS")
public class ShippingAddress {
	
	@Id
	@Column(name = "ADDRESSID")
	private int addressId;
	@Column(name = "HOUSENO")
	private String houseNo;
	@Column(name = "CITY")
	private String city;
	@Column(name = "PINCODE")
	private String pinCode;
	
//	@OneToOne(mappedBy = "addressId")
//	private Order orderId;
//
//	public Order getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(Order orderId) {
//		this.orderId = orderId;
//	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public ShippingAddress() {

	}
}
