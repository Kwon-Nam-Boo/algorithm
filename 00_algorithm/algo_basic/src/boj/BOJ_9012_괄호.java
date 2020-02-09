package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_9012_괄호 {
	
	private static Stack<String> stack;
	private static String[] brackets;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			stack = new Stack<>();
			brackets = br.readLine().split(""); 
			
			int flag =1;
			for (int j = 0; j < brackets.length; j++) {
				if(stack.isEmpty() && brackets[j].equals(")")) {
					flag =0;
					break;
				}else if(brackets[j].equals("(")) {
					stack.push(brackets[j]);
				}else {
					stack.pop();
				}
			}
			if(flag ==0 || !stack.isEmpty()) {
				sb.append("NO").append("\n");
			}else {
				sb.append("YES").append("\n");
			}
			
		}
		System.out.println(sb);
	}

}
