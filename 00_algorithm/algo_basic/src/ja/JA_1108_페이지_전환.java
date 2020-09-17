package ja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JA_1108_페이지_전환 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr = new int[501][501];
		final int M = Integer.MAX_VALUE;
		for (int[] a : arr) {
			Arrays.fill(a, M);
		}
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <=N; i++) {
				if(k == i) continue;
				for (int j = 1; j <=N; j++) {
					if(k == j || i ==j) continue;
					if(arr[i][k]!=M  && arr[k][j]!=M  &&  arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				} 
			}
		}
		int cnt =0;
		double result =0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(arr[i][j] == M) continue;
				cnt++;
				result+=arr[i][j];
			}
		}
		if(cnt == 0) {
			System.out.println(result);
		}else {
			System.out.println(String.format("%.3f", result/cnt));
		}
	}

}
