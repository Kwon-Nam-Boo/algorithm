package eday3;

import java.util.Scanner;

/*
 * 월말평가 소금배달문제
 *  백트래킹
 */

public class 소금배달2 {
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		gogosing(M, 0);
	}
	// M 남은 무게, cnt 지금 까지 사용한 봉지의 수
	// 하지만 값이 크면 시간 터진다 !
	public static void gogosing(int M, int cnt) {
		if(M <0) {
			return;
		}else if(M == 0){
			// 가지치기 가장 먼저 나온게 결국 답
			System.out.println(cnt == Integer.MAX_VALUE ? -1: cnt);
			System.exit(0);
		}else {
			gogosing(M-5, cnt+1);
			gogosing(M-3, cnt+1);			
		}
	}
}
