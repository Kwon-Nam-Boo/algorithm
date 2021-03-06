package com.computer;

public class MyComputer {
	// 마우스, 모니터, 메인프레임, 키보드가 모이면 하나의 컴퓨터가 된다.
	
	//field(data)
	private Mouse mouse;
	private MainFrame frame;
	private KeyBoard keyboard;
	private Monitor monitor;
	
	public MyComputer() {
		mouse = new Mouse("logitec", 55000, true);
		frame = new MainFrame("Intel", 500000, "i7");
		keyboard = new KeyBoard("Deck", 100000, "LED");
		monitor = new Monitor("samsung", 70000,24);
	}
	
	// 모니터, 프레임 전원을 켜기
	public void powerOn(){
		frame.powerOn();
		monitor.powerOn();
	}
	// 모니터, 프레임 전원 끄기
	public void powerOff(){
		 frame.powerOff();
		 monitor.powerOff();
	}
	// 키보드 타이핑, 마우스 클릭, 휠
	public void doJob(){
		keyboard.typing();
		mouse.leftClick();
		mouse.rightClick();
		mouse.wheeling();
		keyboard.typing();
	}
	
	// field의 info 출력
	public void info(){
		mouse.info();
		frame.info();
		keyboard.info();
		monitor.info();
	}
	
}
