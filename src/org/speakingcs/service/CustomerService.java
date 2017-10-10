package org.speakingcs.service;
import java.util.List;

import org.speakingcs.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int customerId);

}
