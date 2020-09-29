package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class eleven1 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s = "aaaa";
		System.out.println(solution(s));
	}
	
	 public static int solution(String S) {
		 	// a가 존재할때 cnt, a가 존재하지 않을때 cnt, 맨앞,맨뒤 cnt
		 	int a1=0,a2=0,se=0;
		 	for (int i = 0; i < S.length(); i++) {
				if(S.charAt(i) == 'a') {
					if(i < S.length()-2 &&S.charAt(i+1)=='a'&& S.charAt(i+2)=='a') return -1;
					// aa로 겹치지 않는경우를 센다
					if((i == 0 || S.charAt(i-1) !='a') && (i == S.length()-1 || S.charAt(i+1)!='a')) {
						if(i == S.length()-1 || i==0) se++;
						else a1++;
					}
				}
				else {
					if(i == 0 || S.charAt(i-1) !='a') {
						if(i == 0) se+=2;
						else  a2+=2;
					}
					if(i == S.length()-1 || S.charAt(i+1)!='a') {
						if(i == S.length()-1) se+=2;
						else a2+=2;
					}
				}
				
			}
		 	// a2 는 반복되므로 2로 나눈다
	        return a1+(a2/2)+se;
	 }
}
