package com.cbc.bank.dao;

import com.cbc.bank.model.Customer;

public interface CustomerDao {

public static String FIND_CUSTOMER_USERNAME_QUERY = "FROM Customer where username=:username";
	
	public static String FIND_ACCOUNT_QUERY="FROM Customer where account_number=:account_number";
	
	public boolean updateCustomerPassword(Customer customer);
	
	public Customer findCustomerUsername(String username);
	
	public boolean fundTransfer(Customer sender, Customer receiver,float amount);
	
	public  Customer findAccount(int accountNo);
	
	public boolean updateCustomerBalance(Customer customer);
}
