package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Toss_1 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String input = br.readLine();
		
		boolean ans = true;
		
		if(input.charAt(input.length()-1) == '1') {
			ans = false;
		}
		
		if(input.length()>1) {
			for (int i = 0; i < input.length()-1; i++) {
				if(input.charAt(i) == '1' && input.charAt(i+1) == '1') {
					ans = false;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
