package com.thread;

public class MainThreadTest implements Runnable{
	public MainThreadTest() {
		//생성자에서 thread 생성
		// 내 자신을 넣음
		//System.out.println(this);
		Thread t = new Thread(this);
		t.start();
		
		try {
			// 순서를 잡아줄수 있다
			// t가 할일을 다 마칠때 까지 기다려준다. (중요)t를 기다려 준다, 메인 메소드가
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// thread아님
		MainThreadTest m = new MainThreadTest();
		m.go();
		
		// 찍히는 순서가 왜 순서대로가 아닐까?
		// 메인스레드에 사용자 정의 스레드가 대게 순서가 밀린다.ㅜㅠㅠㅠ
	}

	@Override
	public void run() {		// thread가 실행하는 메소드
		System.out.println("thread가 작업하는 메소드.....");
	}
	
	public void go() {		// main이 실행하는 메소드
		System.out.println("go method...");
	}
}
