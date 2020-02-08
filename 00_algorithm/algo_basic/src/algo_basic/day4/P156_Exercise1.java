package algo_basic.day4;

import java.util.Stack;

public class P156_Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		stack.push(100);
		stack.push(200);
		System.out.println(stack.peek()+" :  "+stack.size());	// 그저 보는 것
		System.out.println(stack.pop()+" :  "+stack.size());	// 끄집어 내는 것 
		System.out.println(stack.peek()+" :  "+stack.size());	
		if(!stack.isEmpty()) {
			System.out.println(stack.pop()+" :  "+stack.size());	
		}else {
			System.out.println("비었어 ㅜㅜㅜ");
		}	
	}
	
	

}
