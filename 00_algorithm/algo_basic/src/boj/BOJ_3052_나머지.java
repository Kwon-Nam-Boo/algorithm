package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3052_나머지 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		int[] num = new int[10];
		for (int i = 0; i < 10; i++) {
			num[i]= Integer.parseInt(br.readLine()) % 42;
		}
		Arrays.sort(num);
		int count =10;
		for (int i = 1; i < num.length; i++) {
			if(num[i]==num[i-1]) count--;
		}
		System.out.println(count);
	}

}
