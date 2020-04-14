package app;

public class CoronaThreadLambdaTest {

	public static void main(String[] args) {
		
		// 어나니머스
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous thread 생성");
			}
		}).start();
		
		// 람다
		new Thread(()-> System.out.println("Lambda thread 생성")).start();
	}

}
