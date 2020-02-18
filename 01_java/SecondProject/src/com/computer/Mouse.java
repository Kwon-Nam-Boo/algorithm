package com.computer;

public class Mouse extends Parts{
	//private String maker;
	boolean wireless;
	
	//public Mouse(){}

	public Mouse(String maker, int price, boolean wireless) {
		super(maker,price);
		this.wireless = wireless;
	}

	public void leftClick(){
		System.out.println("Mouse_LeftClick");
		
	}
	public void rightClick(){
		System.out.println("Mouse_RightClick");
		
	}
	public void wheeling(){
		System.out.println("Mouse_wheeling");
		
	}

	public void info() {
		super.info();
		System.out.println("wireless: " + wireless);
		System.out.println("------------------------");		
	}

	

	public boolean isWireless() {
		return wireless;
	}

	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}
	
	
	
}







