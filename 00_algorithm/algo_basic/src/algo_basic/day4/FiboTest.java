package algo_basic.day4;

public class FiboTest {
	
	private static long[] memo = new long[100];
	public static void main(String[] args) {
		//System.out.println(fibo(5));
		memo[0] =1;
		memo[1] =1;
		System.out.println(fiboMemo(50));
	}
	
	public static int fibo(int n) {
		if(n<2)
			return 1;
		return fibo(n-1) + fibo(n-2);
	}
	
	public static long fiboMemo(int n) {
		if (memo[n]==0 && n>1 ) {			// 아직 계산 된적이 없고  2보다 큰값이면
			memo[n]= fiboMemo(n-1) + fiboMemo(n-2);
		}
		return memo[n];
		
	}

}
