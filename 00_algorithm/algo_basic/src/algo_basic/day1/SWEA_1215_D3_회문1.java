package algo_basic.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1215_D3_회문1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int N = Integer.parseInt(br.readLine());		// 회문 거리
			String [][] arr = new String[8][8];
			
			for (int r = 0; r < 8; r++) {
				arr[r] = br.readLine().split("");
			}
			int count =0;
			for (int r = 0; r < 8; r++) {
				for (int c = 0; c < 9-N; c++) {
					int mid = N /2;
					
					for (int j = 0; j < mid; j++) {
						
						
						if(!arr[r][j+c].equals(arr[r][N-1+c-j])) break;
						if(j+1  >=mid) count++;
					}
					
				}
			}
			
			for (int c = 0; c < 8; c++) {
				for (int r = 0; r < 9-N; r++) {
					int mid = N /2;
					
					for (int j = 0; j < mid; j++) {
						if(!arr[j+r][c].equals(arr[N-1+r-j][c])) break;
						if(j+1 >= mid) count++;
					}
					
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println();
	}

}
