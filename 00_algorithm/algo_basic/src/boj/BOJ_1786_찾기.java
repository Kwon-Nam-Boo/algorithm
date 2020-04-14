package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1786_찾기 {
	
	private static int count = 0;
	private static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String origin = br.readLine();
		String pattern = br.readLine();
		
		
		KMP(origin, pattern);
		sb.append(count).append("\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
	}
	
	public static void KMP(String origin , String pattern) {
		int[] pi = getPi(pattern);
		//System.out.println(Arrays.toString(pi));
		int j = 0;
		
		for (int i = 0; i < origin.length(); i++) {
			
			while(j >0 && origin.charAt(i)!= pattern.charAt(j))
				j = pi[j-1];
			
			// 맞는 경우
			if(origin.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length()-1) {
					count++;
					list.add(i - pattern.length()+2);
					j = pi[j];
				}
				// 맞았지만 패턴이 끝나지 않앗다면 J를 하나 증가
				else
					j++;	
			}
			
		}
	}
	
	public static int[] getPi(String pattern) {
		
		int m = pattern.length();
		int pi[] =  new int[m];
		int j = 0;
		
		for (int i = 1; i < m; i++) {
			while(j >0 && pattern.charAt(i)!= pattern.charAt(j)) {
				j = pi[j-1]; 
			}
			// 맞는 경우
			if(pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
	
	
}
