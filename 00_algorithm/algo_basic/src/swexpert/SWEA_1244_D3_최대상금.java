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
			
			max = Integer.MIN_VALUE;
			nCr(0,0);
			sb.append(max).append("\n");
		}
		System.out.println(sb);
		
			
	}
	public static void nCr(int r, int k) {
		boolean flag = false;
		if(r == sw) {
			String s ="";
			for (int i = 0; i < number.length; i++) {
				s+=number[i];
			}
			max = Math.max(max, Integer.parseInt(s));
			return;
		}
		for (int i = k; i < number.length; i++) {			// 이중포문으로 조합을 만든다. 뒤는 확인할 필요가 없으니 k
			for (int j = i+1; j < number.length; j++) {
				if(number[j] >= number[i]) {				// 가지치기 앞보다 작은값과는 어떠한 경우든 바꿀 필요가 없다.
					flag = true;
					swap(i,j);
					nCr(r+1, i);							// i보다 전의 과정은 앞에서 다확인햇을것이다.
					swap(i,j);
				}
			}
		}
		if(!flag) {
			swap(number[number.length-2],number[number.length-1]);
			nCr(r+1, number.length-1);
			swap(number[number.length-2],number[number.length-1]);
		}
	}
		
	
	private static void swap(int a, int b) {
		char tmp = number[a];
		number[a] = number[b];
		number[b] = tmp;
	}
	
}	
