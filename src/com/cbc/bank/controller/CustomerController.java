package com.cbc.bank.controller;

import java.util.Scanner;

import com.cbc.bank.impl.CustomerDaoImpl;
import com.cbc.bank.model.Customer;

public class CustomerController {
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		CustomerDaoImpl cdao=new CustomerDaoImpl();
	
		//update password
		System.out.println("*****Updating customer password based on username*****");
		Customer customer=null;
		
		System.out.println("Enter the Username:");
		String user=in.next();
		customer=cdao.findCustomerUsername(user);
		
		while(customer==null) {
			System.out.println("Enter the  correct Username:");
			user=in.next();
			customer=cdao.findCustomerUsername(user);
			if(customer!=null) {
				break;
			}
		}
		System.out.println("Enter the new password:");
		String password=in.next();	
		
		customer.setCustomerPassword(password);
		boolean result=cdao.updateCustomerPassword(customer);
		
		if(result) {
			System.out.println("Customer Password Updated successfully.");
		}
		else {
			System.out.println("Something went wrong.Try again...");
		}
		
		
		//fund Transfer
		System.out.println("*****Fund transfer between 2 customer*****");
		Customer receiver=null;
		int senderAccountNo=10001;
		Customer sender=cdao.findAccount(senderAccountNo);
		
		
		System.out.println("Enter the account number:");
		int receiverAccountNo=in.nextInt();
		
		 receiver=cdao.findAccount(receiverAccountNo);
			
		while( receiver==null) {
			System.out.println("Enter the correct account number:");
			receiverAccountNo=in.nextInt();
			 receiver=cdao.findAccount(receiverAccountNo);
			if( receiver!=null) {
				break;
			}
		}	
		
		System.out.println("Enter the amount to be transfered:");
		float amount=in.nextFloat();
		boolean transfer=cdao.fundTransfer(sender, receiver, amount);
		
		if(transfer) {
			System.out.println("Fund was transfered successfully.");
		}else {
			System.out.println("You have insufficient balance to transfer fund.");
		}	
		
		
	}
}
