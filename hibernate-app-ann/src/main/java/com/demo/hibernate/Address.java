package com.demo.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String doorNo;

	@Column(name = "PIN")
	private String pinCode;
	private String street;

	public Address() {

	}

	public Address(String doorNo, String pinCode, String street) {
		this.doorNo = doorNo;
		this.pinCode = pinCode;
		this.street = street;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}
