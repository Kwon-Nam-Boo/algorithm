package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] p = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < p.length; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);
		
		int result=0;
		int sum =0;
		for (int i = 0; i < p.length; i++) {
			sum+=p[i];
			result+=sum;
		}
		System.out.println(result);
	}

}
