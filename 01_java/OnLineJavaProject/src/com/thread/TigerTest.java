package com.thread;

//1.Thread class 상속받아서 thread 생성
class Tiger extends Thread{
	//run(): thread가 해야 할 일을 적어둔다
	public void run() {		// callback(간접)
		// 스레드의 getName이다
		System.out.println("thread is running.. "+ getName());
	}
}
public class TigerTest {
	
	public static void main(String[] args) {
		// 타이거는 스레드 타입인가요? 네!
		// 타이거는 스레드인가? 네! 스레드가 먼저 만들어지고 타이거가 만들어진다 --> 스레드 중 하나다
		// 타이거가 곧 thread다
		Tiger t1 = new Tiger();
		// thread의 작업 시작을 알리는 메소드 start를 호출하면 run()를 호출한다
		
		// start() 와 run()의 차이 ? run()은 콜백함수
		
		t1.start();	// thread가 실행
		//t1.run();	// main 스레드 실행
		
		// 스레드는 순서가 환경에 따라 다르다 --> join 등으로 순서를 잡아줘야한다.
		Tiger t2 = new Tiger();
		t2.start();	
		Tiger t3 = new Tiger();
		t3.start();	
	}
}
