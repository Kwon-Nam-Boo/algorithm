package com.ssafy;

class Bill{}
class Tom{
	int age = 50;
}
interface Hillary{
	int age = 46;		// public, static ,final 안써도 붙어있다.
}

public class LittleTom extends Tom implements Hillary{
	int age =20;
	
	public void test() {
		System.out.println(age);			//20
		System.out.println(this.age);		//20
		System.out.println(super.age);		//50
		System.out.println(Hillary.age);		//46
	}
	
	public static void main(String[] args) {
		LittleTom little = new LittleTom();						// 리틀톰 입장에서는 age 정보가 3개
		
		if(little instanceof Tom) {
			System.out.println("instance of Tom");
		}
		if(little instanceof Hillary) {
			System.out.println("instance of Hillary");
		}
		
		if(little instanceof LittleTom) {
			System.out.println("instance of LittleTom");
		}
		/*if(little instanceof Bill) {
			System.out.println("instance of Bill");
		}*/
		little.test();
	}
}
