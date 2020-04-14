package com.lambda;

interface Say{
	int something(int a, int b);
}
class Some{
	public void doJob(Say s) {
		System.out.println(s.something(10,20));
	}
}

public class LambdaTest2 {

	public static void main(String[] args) {
		//Some의 doJob() 호출하는 문장
		Some s = new Some();
		s.doJob((a,b) -> {
			return a+b-300;
		});
		
		//Thread. Runnable 객체
		Runnable r = ()->{
			System.out.println("I'm Thread...");
		};
		Thread t = new Thread(r);
		t.start();
		
		Thread t2 = new Thread(() ->{
			System.out.println("you are thread");
		});
		t2.start();
	}
}
