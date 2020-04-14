package com.jdbc.customer.app;

import java.util.ArrayList;

import com.jdbc.customer.dao.CustomerDAO;
import com.jdbc.customer.dao.CustomerDAOImpl;
import com.jdbc.customer.vo.Customer;

public class CustomerTest {
	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAOImpl();
		
		// findAll
		ArrayList<Customer> list = dao.findAll();
		for(Customer c:list) {
			System.out.println(c);
		}
		System.out.println();
		
		// findById
		Customer c1 = dao.findByNum("711");
		System.out.println(c1);
		System.out.println();
		
		// findByAddress
		ArrayList<Customer> addressList = dao.findByAddress("london");
		for(Customer c: addressList) {
			System.out.println(c);
		}
		System.out.println();
		
		// insert
		int insertC = dao.insert(new Customer("119","Kim","seoul"));
		System.out.println(insertC + "개의 데이터 추가");
		
		list = dao.findAll();
		for(Customer c:list) {
			System.out.println(c);
		}
		System.out.println();
		
		// update
		int updateC = dao.update(new Customer("119","Lee" ,"Busan"));
		System.out.println(updateC + "개의 데이터 수정");
		
		list = dao.findAll();
		for(Customer c:list) {
			System.out.println(c);
		}
		System.out.println();
		
		//delete
		int deleteC = dao.delete("119");
		System.out.println(deleteC + "개의 데이터 삭제");
		
		list = dao.findAll();
		for(Customer c:list) {
			System.out.println(c);
		}
		System.out.println();
	}
}
