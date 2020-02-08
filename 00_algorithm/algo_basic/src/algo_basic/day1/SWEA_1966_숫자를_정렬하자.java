package algo_basic.day1;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1966_숫자를_정렬하자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int TC = sc.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}
			Arrays.sort(arr);
			for (int j = 0; j < N; j++) {
				sb.append(arr[j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
