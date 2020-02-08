package algo_basic.day1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1220_D3_Magnetic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <=10; i++) {
			sb.append("#").append(i).append(" ");
            int N = sc.nextInt();
            
            int[][] arr = new int[N][N];
            for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
            int deadlock=0;
            for (int c = 0; c < N; c++) {
            	Stack<Integer> stack = new Stack<>();
            	
				for (int r = 0; r < N; r++) {
					if(arr[r][c] == 1 && stack.size()==0)
						stack.push(arr[r][c]);
					if(arr[r][c] == 2 && !stack.isEmpty()) {
						stack.pop();
						deadlock++;
					}
				}
			}
            sb.append(deadlock).append("\n");
		}
		System.out.println(sb);
	}

}
