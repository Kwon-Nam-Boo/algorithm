package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1918_후위표기식 {

	private static StringBuilder sb = new StringBuilder();
	private static char[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Character> stack = new Stack<>();
		arr = br.readLine().toCharArray();
		
		for (int i = 0; i <arr.length; i++) {
			char c = arr[i];
			int lev = level(c);
			
			switch (c) {
			// 더하기,빼기
			case '+':
			case '-':
			case '*':
			case '/':
				// 비어 있거나 스택맨위 값이 현재보다 레벨이 낮을 까지 계속 한다
				while(!stack.isEmpty() && level(stack.peek()) >= lev) {
					sb.append(stack.pop());
				}
				stack.push(c);
				break;
			case '(':
				stack.push('(');
				break;
			case ')':
				// '(' 만날때 까지 뒤에서 부터 다 넣어준다
				while(stack.peek() != '(') {
					sb.append(stack.pop());
				}
				
				stack.pop();
				break;
			default:
				// 알파벳이면 그냥 넣는다
				sb.append(c);
			}
			
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
		
		
	}
	
	public static int level(char c) {
		switch (c) {
		// 더하기,빼기
		case '+':
		case '-':
			return 2;
		// 곱, 나누기
		case '*':
		case '/':
			return 3;
		case ')':
		case '(':
			return 1;
		}
		return 0;
	}
}
