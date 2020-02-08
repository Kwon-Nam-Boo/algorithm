package algo_basic.day1;

import java.util.Scanner;

public class SWEA_9229_D3_한빈이와_Spot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC = sc.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			
			int N = sc.nextInt();					// 과자 수
			int M = sc.nextInt();					// 최대 과자 무게
			int[] arr = new int[N];
			for (int j = 0; j < N; j++) {			//배열에 과자 저장
				arr[j] = sc.nextInt();
			}
			
			int max = Integer.MIN_VALUE;
			
			for (int j = 0; j < (1<<N); j++) {		// 부분집합
				int sum=0;							// 현재 부분집합에서의 무게합
				int count =0;						// 과자 개수 세기
				for (int j2 = 0; j2 < N; j2++) {
					if(count==2 || sum+arr[j2] > M) break;	// 과자가 이미 두개이거나 무게 초과일경우 break
					if((j & (1<<j2)) > 0) {			
						count++;					// 과자 카운트 및 sum 추가
						sum+=arr[j2];
					}
				}
				if(count!=2) sum =-1;				// 만약 2개이하(보통 1개)의 과자만 가지고 있으면 -1
				max = Integer.max(max, sum);		// 모든 sum 중 최대값 찾기
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);		

	}

}