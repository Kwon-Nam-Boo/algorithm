package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Toss_2 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String input = br.readLine();
		
		boolean ans = true;
		
		st = new StringTokenizer(input, " ");
		
		int a = st.countTokens();
		
		if(a != 6) {
			ans = false;
		}else {
			HashSet<Integer> set = new HashSet<Integer>();
			int b = Integer.parseInt(st.nextToken());
			if(b>45) {
				ans = false;
			}
			for (int i = 1; i < 6; i++) {
				
				int c = Integer.parseInt(st.nextToken());
				if(c>45) {
					ans = false;
					break;
				}
				if(b >= c) {
					ans = false;
					break;
				}
				b = c;
			}
			
		}
		System.out.println(ans);
		
		
	}
}
