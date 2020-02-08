package ja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JA_1438_색종이_초 {
	private static int N;
	private static boolean[][] arr;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new boolean[100][100];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int r = x; r < x+10; r++) {
				for (int c = y; c < y+10; c++) {
					//System.out.println(r);
					//System.out.println(c);
					arr[r][c] = true;
				}
					
			}
			
		}
	
		int count =0;
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c <100; c++) {
				if(arr[r][c]==true) count++;
			}
		}
		System.out.println(count);
		
	}

}
