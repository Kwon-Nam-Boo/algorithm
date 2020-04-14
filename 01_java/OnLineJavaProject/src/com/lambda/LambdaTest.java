package com.lambda;

@FunctionalInterface // 추상메소드가 1개인 인터페이스
interface Work{
	int job(int a, int b);
}

class Person{
	public void test(Work w) {
		int num =w.job(10,20);
		System.out.println(num);
	}
}
class MyWork implements Work{

	@Override
	public int job(int a, int b) {
		return a+b;
	}
	
}

public class LambdaTest {

	public static void main(String[] args) {
		// no lambda
		Person kim = new Person();
		kim.test(new MyWork());
		
		//no lambda-2
		Person park = new Person();
		park.test(new Work() {	// work를 implements 하는  이름은 없는 무명의 클래스를 생성

			@Override
			public int job(int a, int b) {
				return a-b;
			}
			
		});
		// with lambda
		Person lee = new Person();
		// 메소드의 이름이나 클래스 이름 필요 x , 메소드의 파라메터, 바디만 집중해서 기술
		lee.test((a,b) -> {return a*b;});
	}

}

