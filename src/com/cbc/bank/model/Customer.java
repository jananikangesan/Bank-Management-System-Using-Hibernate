package com.cbc.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cbc_customer_table")
public class Customer {
	
	@Id
	@Column(name="account_number")
	private int customerId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="contact_number")
	private long customerNumber;
	
	@Column(name="username")
	private String customerUsername;
	
	@Column(name="password")
	private String customerPassword;
	
	@Column(name="balance")
	private float customerBalance;
	
	public Customer() {
	}

	public Customer(int customerId, String customerName, long customerNumber, String customerUsername,
			String customerPassword, float customerBalance) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerNumber = customerNumber;
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
		this.customerBalance = customerBalance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public float getCustomerBalance() {
		return customerBalance;
	}

	public void setCustomerBalance(float customerBalance) {
		this.customerBalance = customerBalance;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerNumber="
				+ customerNumber + ", customerUsername=" + customerUsername + ", customerPassword=" + customerPassword
				+ ", customerBalance=" + customerBalance + "]";
	}
	
		
	
	
	
}
