package algo_ad.day2;

import org.omg.Messaging.SyncScopeHelper;

public class P2_빠른거듭제곱 {

	public static void main(String[] args) {
		// 분할 정복을 이용해서 빠른거듭 제곱을 구현해보자
		long start =System.nanoTime();
		double result = Math.pow(2, 50);
		System.out.println(result);
		long mid = System.nanoTime();
		result = Math.pow(2, 50);
		System.out.println(result);
		long end = System.nanoTime();
		System.out.printf("api: %d , dnc: %d%n", mid-start, end-mid);

	}
	public double getPower(int x, int n) {
		if(n==1) {
			return x;
		}else if(n%2 ==0){
			double y = getPower(x, n/2);
			return y*y;
		}else {
			double y = getPower(x, n/2);
			return y*y*x;
		}
	}

}
