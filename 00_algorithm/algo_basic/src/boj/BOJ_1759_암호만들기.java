package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	
	private static int R;
	private static int N;
	private static char[] arr;
	private static char[] result;
	private static String operator ="aeiou";
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new char[N];
		result = new char[R];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
	
		Arrays.sort(arr);
	
		nCr(0,0);
		System.out.println(sb);
	}
	
	
	public static void nCr(int r, int k) {
		if(r == R) {
			if(check()) {
				for (int i = 0; i < result.length; i++) {
					sb.append(result[i]);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = k; i < arr.length; i++) {
			result[r] = arr[i];
			nCr(r+1,i+1);
		}
	}
	
	public static boolean check() {
		int m=0;
		int c=0;
		for (int i = 0; i < result.length; i++) {
			if(operator.indexOf(result[i]) >=0) {
				m++;
			}else {
				c++;
			}
		}
		if(m>=1 && c>=2)
			return true;
		else 
			return false;
	}

}
