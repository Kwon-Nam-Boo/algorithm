package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1244_D3_최대상금 {
	
	private static String src;
	private static char[] number;
	private static int sw;
	private static int max;
	private static int[] result;
	private static boolean[][] check = new boolean[1000010][2]; 			// 메모이제이션
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			StringTokenizer st= new StringTokenizer(br.readLine());
			src = st.nextToken();
			number = src.toCharArray();
			sw = Integer.parseInt(st.nextToken());
			
			max = getNum();
			nCr(0,0);
			sb.append(max).append("\n");
		}
		System.out.println(sb);
		
			
	}
	public static void nCr(int r, int k) {
		check[getNum()][r%2] = true;										
		if(r == sw) {
			max = Math.max(max, getNum());
			return;
		}
		for (int i = k; i < number.length; i++) {			
			for (int j = i+1; j < number.length; j++) {
					swap(i,j);												
					if(!check[getNum()][(r+1)%2]) {							// 같은 위치는 확인하지 않는다. 이미 해봣으니
						nCr(r+1,i);							
					}
					swap(i,j);
			}
		}
		
	}
	public static int getNum() {
		String s ="";
		for (int i = 0; i < number.length; i++) {
			s+=number[i];
		}
		return Integer.parseInt(s);
	}
	
	private static void swap(int a, int b) {
		char tmp = number[a];
		number[a] = number[b];
		number[b] = tmp;
	}
	
}	
