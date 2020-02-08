package swexpert;

import java.util.Scanner;

public class SWEA_2805_D3_농장물_수확하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC = sc.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int sum =0; 
			for (int r = 0; r < N; r++) {
				String[] tmp = sc.next().split("");
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(tmp[c]);
					sum+=arr[r][c];
				}
			}
			
			int sumTri =0;
			
			int arrS = N/2;
			
			for (int r = 0; r <arrS; r++) {						// 각 삼각형의 sum을 구한후
				for (int c = 0; c < arrS -r ; c++) {
					sumTri+=arr[r][c];		
				}
			}
			for (int r = 0; r < arrS; r++) {
				for (int c = N -arrS +r; c < N ; c++) {
					sumTri+=arr[r][c];	
				}
			}
			for (int r = N -arrS; r < N; r++) {
				for (int c = 0; c < r - arrS  ; c++) {
					sumTri+=arr[r][c];
				}
			}
			for (int r = N -arrS; r < N; r++) {
				for (int c = N +arrS-r ; c < N  ; c++) {
					sumTri+=arr[r][c];
				}
			}	
			int result = sum -sumTri;							// 전체 sum에서 빼면 된다.
			sb.append(result).append("\n");
		}
		System.out.println(sb);	
	}

}