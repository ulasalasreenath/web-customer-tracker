package org.speakingcs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.speakingcs.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

		List<Customer> customers = query.list();
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);

	}

	@Override
	public Customer getCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, theId);
	}

	@Override
	public void deleteCustomer(int customerId) {
		
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = session.createQuery("delete from Customer where id=:theCustomeId");
		theQuery.setParameter("theCustomeId", customerId);
		theQuery.executeUpdate();
	}

}
