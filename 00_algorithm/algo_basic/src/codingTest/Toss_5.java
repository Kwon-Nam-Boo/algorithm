package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Toss_5 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String input1 = br.readLine();
		String input2 = br.readLine();
		
		
		st = new StringTokenizer(input1);
		int len = st.countTokens();
		
		int[] kim = new int[len];
		int[] ei = new int[len];
		int[] ans = new int[len];
		
		int store = 0;
	
		for (int i = 0; i < len; i++) {
			kim[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(input2);
		for (int i = 0; i < len; i++) {
			ei[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < len; i++) {
			if(kim[i] > ei[i]) {
				ans[i] = kim[i] - ei[i];
				if(store >= kim[i] - ei[i]) {
					store -= kim[i] - ei[i];
					ans[i] = 0;
				}else {
					ans[i] = kim[i] - ei[i] - store;
					store =0;
				}
			}else if(kim[i] == ei[i]){
				ans[i] = 0;
			}else {
				ans[i] = 0;
				store += ei[i] - kim[i];
			}
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] +" ");
		}
		System.out.println();
	}
	
	
		
}
