package swexpert;


import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2005_D2_파스칼의_삼각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC = sc.nextInt();
		
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append("\n");
			int N =sc.nextInt();
			int[][] arr = new int[N][N];
			
			if(N>=1) {
				arr[0][0] = 1;
				sb.append(arr[0][0]).append("\n");
			}
		
			if(N>=2) {
				arr[1][0] = 1;
				arr[1][1] = 1;
				sb.append(arr[1][0]).append(" ").append(arr[1][1]).append("\n");
			}
	
			if(N >2)
				for (int r = 2; r < N; r++) {
					for (int c = 0; c <= r; c++) {
						if(c== 0 || c==r) arr[r][c] = 1;
						else arr[r][c] = arr[r-1][c-1] +arr[r-1][c];
						sb.append(arr[r][c]).append(" ");
					}
					sb.append("\n");
				}
			//System.out.println(Arrays.deepToString(arr));
		}
		
		System.out.println(sb);
	}
	
	
}