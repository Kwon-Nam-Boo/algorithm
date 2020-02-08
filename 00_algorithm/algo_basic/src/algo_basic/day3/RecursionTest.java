package algo_basic.day3;

import org.junit.jupiter.api.Test;

public class RecursionTest {

	public static void main(String[] args) {
		//recur2(3);
		
	}
	public static void recur2(int k) {
		// Base case: 종료 조건
		if(k==0) {
			System.out.println("재귀 종료");
			return;
		}else {
			System.out.println("Before: " + k);
			recur2(k-1);
			System.out.println("After: " + k);
		}
	}
	public static void recur3(int k, int n, int[]arr) {
		if(k==n) {
			return;
		}
		System.out.println(k + " : " + arr[0]);
		arr[0] = k;
		recur3(k+1,n,arr);
		arr[0] = k;
		System.out.println(k + " : " + arr[0]);
	}
	@Test								// junit5 main 안거치고 단위테스트 가능
	public void recur3Test(){
		int[] arr = new int[1];
		recur3(0,3,arr);
	}
	
	public static int recur4(int n) {
		if(n<=0) {
			return 0;
		}else {
			return n+ recur4(n-1);
		}
	}
	@Test
	public void recur4() {
		System.out.println(recur4(3));
	}
	
	int cnt2;
	public void recur6(int k, int n) {
		if(k==n) {
			cnt2++;
			return;
		}
		recur6(k+1,n);
		recur6(k+1,n);
	}
	@Test
	public void recur6Test() {
		recur6(0,3);
		System.out.println(cnt2);
	}
}
