package com.object;

class Employee{
	int num;
	String name;
	int salary;
	
	public Employee() {
		this(0,null,0);
	}
	public Employee(int num, String name, int salary) {
		this.num = num;
		this.name = name;
		this.salary = salary;
	}

	double getBonus() {
		return salary*0.1;
	}
}

public class Manager extends Employee{
	int mcode;

	public Manager(int num, String name, int salary, int mcode) {
		super(num, name, salary);		// super() 부모의 생성자 호출
		this.mcode = mcode;
		// TODO Auto-generated constructor stub
	}

	@Override
	double getBonus() {
		// TODO Auto-generated method stub
		return salary*0.3;
	}
	
	
}
class Ceo extends Employee{
	int tel;
	
	public Ceo(int num, String name, int salary, int tel) {
		super(num, name, salary);
		this.tel = tel;
	}

	@Override
	double getBonus() {
		return salary*0.5;
	}
	
}