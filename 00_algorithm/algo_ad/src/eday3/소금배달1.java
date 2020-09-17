package eday3;

import java.util.Scanner;

/*
 * 월말평가 소금배달문제
 * 
 */
public class 소금배달1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		
		int cnt = 0;
		
		while(M % 5 != 0) {		// 5로 나누어 떨어지지 않는다면
			M -=3;
			cnt++;
		}
		
		if(M<0) {	// 음수면 해가 없는 경우
			System.out.println(-1);
		}else {
			cnt += M/5;
			System.out.println(cnt);
		}
//		Greedy
//		3, 5,7, 11kg
//		소금 봉지의 무게 종류
	}

}
