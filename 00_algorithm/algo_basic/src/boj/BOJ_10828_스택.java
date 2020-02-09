package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {
	
	private static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			doStack(word,st);
			
		}
	}
	public static void doStack(String word, StringTokenizer st) {
		switch(word) {
		case "push":
			stack.push(Integer.parseInt(st.nextToken()));
			break;
		case "top":
			if(stack.isEmpty()) {
				System.out.println("-1");
			}else {
				System.out.println(stack.peek());
			}
			break;
		case "pop":
			if(stack.isEmpty()) {
				System.out.println("-1");
			}else {
				System.out.println(stack.pop());
			}
			break;
		case "size":
			System.out.println(stack.size());
			break;
		case "empty":
			if(stack.isEmpty()) {
				System.out.println("1");
			}else {
				System.out.println("0");
			}
			break;
		}
	}
}
