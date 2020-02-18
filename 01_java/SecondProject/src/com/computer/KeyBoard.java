package com.computer;

public class KeyBoard extends Parts{
	private String type;	
	//private String maker;	
	
	//public KeyBoard(){}
	
	public KeyBoard(String maker, int price, String type) {
		super(maker,price);
		this.type = type;
	
	}

	public void typing(){
		System.out.println("KeyBoard typing...");
		System.out.println("----------");
	}
	
	
	public void info() {		
		super.info();
		System.out.println("type: " + type);
		System.out.println("------------------------");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
