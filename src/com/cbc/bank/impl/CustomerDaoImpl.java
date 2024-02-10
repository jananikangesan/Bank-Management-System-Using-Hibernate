package com.cbc.bank.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cbc.bank.dao.CustomerDao;
import com.cbc.bank.model.Customer;
import com.cbc.bank.util.HibernateUtil;

public class CustomerDaoImpl  implements CustomerDao{

	SessionFactory factory;

    public CustomerDaoImpl() {
        factory = HibernateUtil.getSessionFactory();
    }

	@Override
	public Customer findCustomerUsername(String username) {
		// TODO Auto-generated method stub
		
		Session session=factory.openSession();
	
		Customer customer = null;
		 try {
			 Query query=session.createQuery(CustomerDao.FIND_CUSTOMER_USERNAME_QUERY);
			 query.setParameter("username",username);
				
			 customer=(Customer) query.uniqueResult();
		    } catch (HibernateException e) {
		        // Handle Hibernate-specific exceptions
		        e.printStackTrace();
		    } catch (Exception e) {
		        // Handle general exceptions
		        e.printStackTrace();
		    } finally {
		        if (session != null && session.isOpen()) {
		            session.close();
		        }
		    }

		
		return customer;
	}

	@Override
	public boolean updateCustomerPassword(Customer customer) {
		// TODO Auto-generated method stub
		
		Session session=factory.openSession();
		
		Transaction transaction=null;
		boolean result=false;
		try {
			transaction=session.beginTransaction();
			session.update(customer);
			transaction.commit();
			result=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null) {
				transaction.rollback();
			}
			System.err.println("Error updating customer password: " + e.getMessage());
		}finally {
			if (session != null && session.isOpen()) {
	            session.close(); 
	        }
		}
		
		return result;
	}

	@Override
	public Customer findAccount(int accountNo) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		
		Customer customer = null;
		 try {
			 Query query=session.createQuery(CustomerDao.FIND_ACCOUNT_QUERY);
			 query.setParameter("account_number",accountNo);
				
			 customer=(Customer) query.uniqueResult();
		    } catch (HibernateException e) {
		        // Handle Hibernate-specific exceptions
		        e.printStackTrace();
		    } catch (Exception e) {
		        // Handle general exceptions
		        e.printStackTrace();
		    } finally {
		        if (session != null && session.isOpen()) {
		            session.close();
		        }
		    }
		return customer;
	}

	@Override
	public boolean updateCustomerBalance(Customer customer) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		
		Transaction transaction=null;
		boolean result=false;
		try {
			transaction=session.beginTransaction();
			session.update(customer);
			transaction.commit();
			result=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null) {
				transaction.rollback();
			}
			System.err.println("Error updating customer balance: " + e.getMessage());
		}finally {
			if (session != null && session.isOpen()) {
	            session.close(); 
	        }
		}
		
		return result;
	}
	
	@Override
	public boolean fundTransfer(Customer sender, Customer receiver, float amount) {
		// TODO Auto-generated method stub
		
		boolean result=false;
		float senderBalance=sender.getCustomerBalance()-amount;
		boolean updateSenderResult=false;
		boolean updateReceiverResult=false;
		if(senderBalance>0) {
			sender.setCustomerBalance(senderBalance);
			updateSenderResult=updateCustomerBalance(sender);
			float receiverBalance=receiver.getCustomerBalance()+amount;
			receiver.setCustomerBalance(receiverBalance);
			updateReceiverResult=updateCustomerBalance(receiver);
		}
		if(updateReceiverResult && updateSenderResult) {
			result=true;
		}
		
		return result;
	}

}
