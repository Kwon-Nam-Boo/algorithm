package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_2785_가로수 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int interval[] = new int[N-1];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length-1; i++) {
			interval[i] = arr[i+1]-arr[i];
		}
		int gcd = euclidGCD(interval[0], interval[1]);
		
		for (int i = 2; i < interval.length; i++) {
			gcd = euclidGCD(interval[i], gcd);
		}
		int ans  = 0;
		for (int i = 0; i < interval.length; i++) {
			ans+=(interval[i]/gcd-1);
		}
		System.out.println(ans);
	}
	
	public static int euclidGCD(int x, int y){
		if(y == 0) {
			return x;
		}else {
			return euclidGCD(y,x%y);
		}
	}
}
