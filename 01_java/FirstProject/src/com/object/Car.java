package com.object;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;

public class Car {
	int num;
	String owner;
	String model;
	
	/*public Car() {		// 생성자로 초기화
		num = 99;
		owner = "Boss";
		model = "ford";
	}*/
	
	// this(): 생성자 안에서 다른 생성자 호출
	
	public Car(){			// 디폴트를 실행하면
		this(0);			// this(0) 생성자를 실행
	}
	public Car(int num){	// num =0;
		this(num, "xyz");	// 또실행 
	}
	Car(int num, String model){		// num =0, model ="anonymous"
		this(num,model,"anonymous");
		
	};
	Car(int num, String model,String owner){	
		this.num = num;
		this.model = model;
		this.owner = owner;
	};
	
	
	public void run() {
	
		System.out.println("Running");
	}
	public void stop() {
		System.out.println("Stop!");
	}
	public void info() {
		System.out.println(num);
		System.out.println(owner);
		System.out.println(model);
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Car car = new Car();
		car.run();
		car.stop();
		car.info();
		System.out.println();
		
		car.num = 7821;
		car.model = "kia";
		car.owner = "BigMaMa";
		car.info();		*/
		Car car1 = new Car();		
		Car car2 = new Car(4058);		
		Car car3 = new Car(6856,"ford");		
		Car car4 = new Car(7712,"kia","lee");
		
		car1.info();
		car2.info();
		car3.info();
		car4.info();
		
		Frame f = new Frame("test");
		f.setLayout(new FlowLayout());
		Checkbox ch = new Checkbox("one");
		Checkbox ch2 = new Checkbox("two",true);
		Checkbox ch3 = new Checkbox("three", false);
		
		
		Button b = new Button("ok");
		f.add(b);
		f.add(ch);
		f.add(ch2);		
		f.add(ch3);
		
		f.setSize(500,500);
		f.setVisible(true);
	}

}
