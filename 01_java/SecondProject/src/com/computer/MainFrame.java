package com.computer;

public class MainFrame extends Parts{
	//private String maker;
	private String cpu;
	
	//public MainFrame() {}
	
	public MainFrame(String maker, int price ,String cpu) {
		super(maker, price);
		this.cpu = cpu;
	}
	
	public void powerOn(){
		System.out.println("MainFrame_PowerOn");
		
	}
	public void powerOff(){
		System.out.println("MainFrame_PowerOff");
		
	}
	
	
	public void info() {		
		super.info();	
		System.out.println("cpu: " + cpu);		
		System.out.println("------------------------");
		
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	
	
}








