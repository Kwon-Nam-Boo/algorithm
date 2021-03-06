package com.ssafy.product;

import java.io.Serializable;

public abstract class Product implements Serializable{
	private int id;
	private String name;
	private int price;
	private int num;
	
	public Product(int id, String name, int price, int num) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", price=" + price + ", num=" + num;
	}
}