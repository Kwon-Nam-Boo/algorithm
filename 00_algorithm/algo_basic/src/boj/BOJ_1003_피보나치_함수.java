package boj;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치_함수 {

	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 int TC = Integer.parseInt(br.readLine());
		 for (int t = 0; t < TC; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] memoX = new int[N+1];
			int[] memoY = new int[N+1];
			memoX[0] = 1;
			memoY[0] = 0;
			if(N!=0) {
			memoX[1] = 0;
			memoY[1] = 1;
			}
			for (int i = 2; i <= N; i++) {
				memoX[i] = memoX[i-1]+ memoX[i-2];
				memoY[i] = memoY[i-1]+ memoY[i-2];
			}
			sb.append(memoX[N]).append(" ").append(memoY[N]).append("\n");			
		}
		 System.out.println(sb);
	}

}
