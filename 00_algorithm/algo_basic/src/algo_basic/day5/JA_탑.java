package algo_basic.day5;

import java.util.Scanner;
import java.util.Stack;

public class JA_탑 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		Stack<Wall> stack = new Stack<>();
		for (int i = 1; i <= n; i++) {
			int newHeight = sc.nextInt();
			while(!stack.isEmpty()) {
				if(stack.peek().height < newHeight) {
					stack.pop();
				}else{
					break;
				}
				
			}
			if(stack.isEmpty()) {
				sb.append("0 ");
			}else {
				sb.append(stack.peek().idx +" ");
			}
			stack.push(new Wall(newHeight,i));
		}
		System.out.println(sb);
		
		
	}
	static class Wall{
		int height;
		int idx;
		public Wall(int height, int idx) {
			super();
			this.height = height;
			this.idx = idx;
		}
	}
}
