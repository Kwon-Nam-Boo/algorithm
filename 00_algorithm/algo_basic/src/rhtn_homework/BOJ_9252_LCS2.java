package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9252_LCS2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = "0" + br.readLine();
		String s2 = "0"+ br.readLine();
		
		String[][] DP = new String[s1.length()][s2.length()];
		
		for (int r = 0; r < DP.length; r++) {
			for (int c = 0; c < DP[r].length; c++) {
				if(r ==0 || c ==0) {
					DP[r][c] = "";
					continue;
				}
				// 내용이 같다면, 이전 DP보다 1 길어진 최장 공통 부분문자열
				if(s1.charAt(r) == s2.charAt(c)) {
					DP[r][c] = DP[r-1][c-1]+ s2.charAt(c);
				}
				// 내용이 다르다면, 왼 or 위로 큰 DP를 그대로 챙겨온다
				else{
					if(DP[r-1][c].length() > DP[r][c-1].length()) {
						DP[r][c] = DP[r-1][c];
					}else {
						DP[r][c] = DP[r][c-1];
					}
				}
			}
		}
		
		System.out.println(DP[s1.length()-1][s2.length()-1].length());
		if(DP[s1.length()-1][s2.length()-1].length() != 0) {
			System.out.println(DP[s1.length()-1][s2.length()-1]);
		}
		//System.out.println(DP[s1.length()-1][s2.length()-1]);
	}

}
