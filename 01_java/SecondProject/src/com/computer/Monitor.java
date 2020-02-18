package com.computer;

public class Monitor extends Parts{
	//private String maker;
	private double size;	

	//public Monitor(){}
	
	public Monitor(String maker, int price ,double size) {
		super(maker, price);
		this.size = size;
	}

	public void powerOn(){
		System.out.println("Monitor_PowerOn");	
	}

	public void powerOff(){
		System.out.println("Monitor_PowerOff");	
		
	}
	
	@Override
	public void info() {
		super.info();
		System.out.println("size: " + size);
		System.out.println("------------------------");
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}
	
	
}


