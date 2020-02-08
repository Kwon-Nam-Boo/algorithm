package swexpert;

import java.util.Scanner;

public class SWEA_5356_D3_의석이의_세로 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC = sc.nextInt();
		sc.nextLine();
		String[][] arr = new String[5][];
		
		for (int i = 1; i <= TC; i++) {
			
			sb.append("#").append(i).append(" ");
			
			int max = Integer.MIN_VALUE;					// 열의 최대값
			for (int k = 0; k < 5; k++) {
				String[] c = sc.nextLine().split("");
				
				arr[k] = new String[c.length];
				for (int j = 0; j < c.length; j++) {
					arr[k][j] = c[j];
				}
				max = Integer.max(max, c.length);
			}
			
			for (int c = 0; c < max; c++) {					// 열의 최대값 내에서
				for (int r = 0; r < 5; r++) {				// 현재 열의 길이보다 작은거나 같은것만 출력
					if(arr[r].length-1 >= c) sb.append(arr[r][c]);
					else continue;							// 나머지는 뛰어넘기
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
			
	}

}