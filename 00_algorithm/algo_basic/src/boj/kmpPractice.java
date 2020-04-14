package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class kmpPractice {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String origin = br.readLine();
		String pattern = br.readLine();
		
		KMP(origin, pattern);

	}

	private static void KMP(String origin, String pattern) {
		int[] pi = getPi(pattern);
		int j = 0;
		char[] originChar = origin.toCharArray();
		//System.out.println(Arrays.toString(originChar));
		char[] patternChar =pattern.toCharArray();
		
		for (int i = 0; i < originChar.length; i++) {
			while(j > 0 && originChar[i] != patternChar[j]) {
				j = pi[j-1];
			}
			if(originChar[i] == patternChar[j]) {
				if(j == pattern.length()-1) {
					//System.out.println(i);
					System.out.println(i - pattern.length()+1);
					// 여러개 일 경우 확인을 위해
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		
	}

	private static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		
		int j = 0;
		char[] patternChar =pattern.toCharArray();
		
		for (int i = 1; i < patternChar.length; i++) {
			// 서로 다르다면 .. 이전위치의 pi값으로 회귀!
			while(j>0 && patternChar[j] != patternChar[i]) {
				j = pi[j-1];
			}
			//같다면
			if(patternChar[j] == patternChar[i]) {
				pi[i] = ++j;
			}
			// j == 0 이면 i만 1증가
		}
		return pi;
	}

}
