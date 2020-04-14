package edu.ssafy.cus;

import java.util.List;

public interface DAO {
	public void insertCustomer(int num, String name, String address);
	public void deleteCustomer(int num);
	public void updateCustomer(int num, String name, String address);
	public List<Customer> allViewCustomer();
	public Customer findCustomer();
}
