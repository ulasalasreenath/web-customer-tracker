package org.speakingcs.dao;

import java.util.List;

import org.speakingcs.entity.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int theId);

	void deleteCustomer(int customerId);
	
}
