package com.jdbc.customer.vo;

//vo(값을 저장하기 위한 용도)

public class Customer {
	private String num;
	private String name;
	private String address;
	
	public Customer(){};
	
	public Customer(String num, String name, String address) {
		super();
		this.num = num;
		this.name = name;
		this.address = address;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [num=" + num + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
