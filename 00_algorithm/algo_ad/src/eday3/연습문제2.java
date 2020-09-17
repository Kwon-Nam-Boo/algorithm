package eday3;

import java.util.Scanner;

public class 연습문제2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] memo = new int[N+1];
		memo[1] = 2;
		memo[2] = 5;
		for (int i = 3; i <=N; i++) {
			memo[i] = memo[i-1]*2 + memo[i-2];
		}
		System.out.println(memo[N]);
	}
	//end of main
}// end of class
