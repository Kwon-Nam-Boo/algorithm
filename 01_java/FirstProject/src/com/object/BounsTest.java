package com.object;

public class BounsTest {
	
	void printBonus(Employee who) {
		if(who instanceof Manager) {			// 부모를 먼저 쓰는것이 좋다.
			
		}
		else if(who instanceof Employee) {
			
		}
		
		System.out.println(who.getBonus());
	}
	/*void printBonus(Manager who) {
		System.out.println(who.getBonus());
		System.out.println("check");
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee tom = new Employee(123, "Tom Lee", 3000);
		//System.out.println(tom.getBonus());
		
		
		Manager kim = new Manager(124,"Sung Kim",3600,11);
		//System.out.println(kim.getBonus());
		
		Ceo wang = new Ceo(124,"Sung Wang",4000,99991111);
		//System.out.println(wang.getBonus());
		
		Employee ka = new Manager(123, "ka Lee", 3000,11);
		//System.out.println(ka.getBonus());
		
		BounsTest bt = new BounsTest();
		bt.printBonus(tom);
		bt.printBonus(kim);
		
		Employee q = new Employee(123, "Tom Lee", 3000);
		Employee x = new Manager(124,"Sung Kim",3600,11);
		
		Manager q1 = (Manager) x;
		Manager q2 = (Manager) q;
		
	}

}
