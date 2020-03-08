package boj;

import java.util.Scanner;

public class BOJ_2023_신기한_소수 {
	
	private static int N;
	private static int[] start= {2,3,5,7};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
	
		for (int i = 0; i < start.length; i++) {
			dfs(start[i], 1);
		}
	}
	public static void dfs(int num, int len) {
		// 기본
		if(len == N) {
			System.out.println(num);
			return;
		}
		// 재귀
		for (int i = 1; i <= 9; i++) {
			if(primeCheck(num*10+i)) {
				dfs(num*10+i, len+1);
			}
		}
	}
	
	public static boolean primeCheck(int n) {
	
		for (int a = 2; a <= (int) Math.sqrt(n); a++) {
			if(a!=1 && n % a == 0) {	// 1이 아닌 수로 나누어떨어지면?
				return false;
			}	
		}
		return true;
	}
}
