package ja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JA_2074_홀수_마방진 {
	private static int N;
	private static int[][] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		fill(0,N/2,1);
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(arr[r][c] +" ");
			}
			System.out.println();
		}

	}
	public static void fill(int r, int c, int num) {
		if(num> N*N) return;
		
		if(r<0) r =N-1;
		if(c<0) c =N-1;
		arr[r][c] =num;
		
		if(num%N!=0) fill(r-1, c-1, num+1);
		else fill(r+1,c,num+1);
	}

}
