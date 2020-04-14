package com.thread;
// 2. Runnable 인터페이스 구현해서 thread 생성

class Lion implements Runnable{
	
	//run(): thread가 해야 할 일을 적어둔다
	@Override
	public void run() {
		// 현재 실행하는 스레드가 누구지? currentThread
		//Thread t = Thread.currentThread();
		System.out.println("thread is running.. "+ Thread.currentThread().getName());
	}
}
public class LionTest {

	public static void main(String[] args) {
		//Runnable객체 (run은 있지만 thread는 아니다) --> thread에 넣어준다..?
		Lion l1 = new Lion();
		// 스레드 t1은 l1의 내용을 전달 받는다.
		Thread t1 = new Thread(l1);
		t1.start();
		
		// 이렇게도 만들기 가능
		Thread t2 = new Thread(l1);
		t2.start();
		Thread t3 = new Thread(l1);
		t3.start();
		
		//t1,t2,t3는 사용자 정의 스레드
	}

}
