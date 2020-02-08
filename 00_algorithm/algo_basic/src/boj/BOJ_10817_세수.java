package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10817_세수 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] three = new int[3];
		for (int i = 0; i < 3; i++) {
			three[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(three);
		System.out.println(three[1]);
	}
	
}
