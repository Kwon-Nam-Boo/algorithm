package swexpert;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1216_D3_회문2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			
			
			int N = Integer.parseInt(br.readLine());		// 케이스 넘버
			
			String [][] arr = new String[100][100];
			
			for (int r = 0; r < 100; r++) {
				arr[r] = br.readLine().split("");
			}
			
			int result =1;
			
				for(int num =100 ;num>1 ;num--) {
					if(result>1) {
						break;
					}
					for (int r = 0; r < 100; r++) {
						for (int c = 0;  c< 101-num; c++) {
							int temp =0;
							
							for (int k = 0; k < num /2; k++) {
								if(!arr[r][c+k].equals(arr[r][c+ num-k-1])) { 
									temp = -1;
									
								}
								
							}
							if(temp ==0) {
								result = num;
								
							}
							
						}
					}
					
					for (int r = 0 ; r < 101-num; r++) {
						for (int c = 0; c < 100; c++) {
							int temp =0;
							int mid = num /2;
							for (int j = 0; j < mid; j++) {
								if(!arr[j+r][c].equals(arr[num-1+r-j][c])) {
									temp = -1;
									break;
								}
							}
							if(temp ==0) {
								result = num;
								
							}
							
						}
					}
				}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
