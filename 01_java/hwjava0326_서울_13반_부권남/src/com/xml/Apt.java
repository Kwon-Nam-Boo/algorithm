package com.xml;

public class Apt {

    private String name;
    private String Beop;
    private String price;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeop() {
		return Beop;
	}
	public void setBeop(String beop) {
		Beop = beop;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Apt [name=" + name + ", Beop=" + Beop + ", price=" + price + "]";
	}
	
       
}
