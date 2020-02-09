package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799_쇠막대기 {
	
	private static Stack<String> stack;
	private static String[] stick;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		stick = br.readLine().split(""); 
		stack = new Stack<>();
		boolean razerPoint = false;
		int sum =0;
		for (int i = 0; i < stick.length; i++) {
			if(stick[i].equals("(")) {				// '(' 가 오면
				stack.push("(");					// 스택에 쌓는다
				razerPoint = true;
			}
			else if(stick[i].equals(")") && razerPoint == true){
				stack.pop();
				sum+=stack.size();
				razerPoint =false;
			}
			else if(stick[i].equals(")")) {
				stack.pop();
				sum+=1;
				razerPoint =false;
			}
		}
		System.out.println(sum);
	}

}
