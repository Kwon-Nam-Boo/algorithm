package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1240_D3_최대상금 {
	
	private static String src;
	private static char[] number;
	private static int sw;
	private static int[] result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			String[] tmp = st.nextToken().split("");
			src = 
			for (int j = 0; j < tmp.length; j++) {
				src[j] = Integer.parseInt(tmp[j]);
			}
			sw = Integer.parseInt(st.nextToken());
		}
		result = new int[2];
		nCr(0,0);		
	}
	public static void nCr(int r, int k) {
		if(r == sw) {
			
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				
			}
		}
	}
	private static void swap(int a, int b) {
		
	}
	
}	
