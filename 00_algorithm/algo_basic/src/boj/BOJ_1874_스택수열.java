package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_스택수열 {
	
	private static Stack<Integer> stack = new Stack<>();
	private static int[] nums;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int c =1;
		int flag =1;
		for (int i = 0; i < N; i++) {
			if(stack.isEmpty()) {
				stack.push(c);
				sb.append("+").append("\n");
				c++;
			}
			while(true) {
				if(nums[i] == stack.peek()) {
					stack.pop();
					sb.append("-").append("\n");
					break;
				}else if(nums[i] < stack.peek()) {
					flag = 0;
					break;
				}
				stack.push(c);
				sb.append("+").append("\n");
				c++;
			}
			if(flag==0) {
				sb.setLength(0);
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}

}
