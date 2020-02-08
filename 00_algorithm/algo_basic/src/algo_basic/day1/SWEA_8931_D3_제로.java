package algo_basic.day1;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_8931_D3_제로 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC = sc.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			int N = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
			for (int j = 0; j < N; j++) {
				int money =sc.nextInt();
				if(money!=0) stack.push(money);
				else stack.pop();
			}
			int sum =0;
			while(!stack.isEmpty()) {
				sum+=stack.pop(); 
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
