package ch04;

class MyThread2 implements Runnable{
	@Override
	public void run() {
		try {
			while(true) {
				System.out.println("Hello, Runnable!");
				Thread.sleep(500);
			}
		}catch (InterruptedException e) {
			System.out.println("I'm interrupted");
		}
		
	}
}

public class ThreadExample2 {
	public static void main(String[] args) {
		MyThread2 thread = new MyThread2();
		thread.run();
		System.out.println("Hello , My Runnable child!");
	}
}
