package algo_basic.day1;

import java.util.Scanner;

public class SWEA_9229_D3_한빈이와_Spot_2 {

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
			
			int max = -1;							// 최대값
			
													// 두봉지만 이므로 한정할 수 있다.
			for (int j = N-1; j>=0  ; j--) {		
				for (int j2 = 0; j2 < j; j2++) {
					if(arr[j]+arr[j2] > M) continue;	// 무게를 넘으면 패스
					max = Integer.max(max, arr[j]+arr[j2]); // 최대의 무게 과자를 찾는다
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);		

	}

}