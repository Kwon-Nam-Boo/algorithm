package com.jdbc.customer.dao;

import java.util.ArrayList;

import com.jdbc.customer.vo.Customer;
// 서비스를 이용하는 클라이언트에 제공하는 목적
public interface CustomerDAO {
	public ArrayList<Customer> findAll();
	
	public Customer findByNum(String num);
	public ArrayList<Customer> findByAddress(String address);
	
	public int insert(Customer c);
	public int delete(String num);
	public int update(Customer c);
	
	
	
}
