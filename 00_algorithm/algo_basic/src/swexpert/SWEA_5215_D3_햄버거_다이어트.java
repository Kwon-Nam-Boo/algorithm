package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_5215_D3_햄버거_다이어트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC = sc.nextInt();
		
		for (int i = 1; i <=TC ; i++) {			// 테스트 케이스
			int n = sc.nextInt();				// 재료 개수
			int mk = sc.nextInt();				// 최대 칼로리 수치
			
			int[] mat = new int[n];				// 재료, 칼로리 배열
			int[] kal = new int[n];
			
			
			for (int j = 0; j < n; j++) {		// 재료, 칼로리 배열 저장
				mat[j] = sc.nextInt();
				kal[j] = sc.nextInt();
			}
			
			int answer = Integer.MIN_VALUE;		// 답
			
			for (int j = 0; j < (1 << n); j++) {	// 부분집합을 통한 정답 탐색
				int sum = 0;
				int sum_k =0;
				for (int j2 = 0; j2 < n; j2++) {	
					if((j & (1 << j2)) > 0) {		// j번째 비트가 1인지 확인
						sum_k += kal[j2];			// 현재 부분집합 칼로리를 더해서
						if(sum_k > mk)				// 넘으면 0으로 넘김
							continue;
						sum += mat[j2];				// 현재 부분집합의 점수 합
					}
				}
				answer = Integer.max(answer, sum);	// 모든 sum중 최대를 찾는다
			}
			sb.append("#").append(i).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb);
	}

}