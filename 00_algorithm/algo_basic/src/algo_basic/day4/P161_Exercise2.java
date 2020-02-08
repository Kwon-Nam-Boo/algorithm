package algo_basic.day4;

import java.util.Scanner;
import java.util.Stack;

public class P161_Exercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		
		String test = sc.next();
		test = test.trim();
		System.out.println(test);
		
		boolean status = true;
		for (int i = 0; i < test.length(); i++) {
			if(test.charAt(i) == '(') {
				stack.push(test.charAt(i));
			}
			else if(test.charAt(i) == ')') {
				if(stack.isEmpty()) {
					status =false;
					break;				}
				
				stack.pop();
			}
		}
		if(stack.isEmpty() && status) {
			System.out.println("Ok");
		}else
			System.out.println("Wrong");
	}

}
