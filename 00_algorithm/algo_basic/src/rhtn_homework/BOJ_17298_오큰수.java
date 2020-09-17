package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] ans = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] =Integer.parseInt(st.nextToken());
		}
		
		Stack<Pair> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			// 들어오는게 더크다면? 오큰수이다. 스택이 비거나 더 큰걸 만날때 까지는 그 모든게 오큰수이다
			while(!stack.isEmpty() && stack.peek().n < arr[i]) {
				ans[stack.pop().idx] = arr[i];
			}
			// 비어있거나 더큰걸 만난경우는 넣기만한다
			stack.push(new Pair(i,arr[i]));
			
		}
		
		while(!stack.isEmpty()) {
			ans[stack.pop().idx] = -1;
		}
		
		for (int i = 0; i < ans.length; i++) {
			//System.out.print(ans[i] +" ");
			sb.append(ans[i] +" ");
		}
		System.out.println(sb);
		
	}
	
	public static class Pair{
		int idx, n;

		public Pair(int idx, int n) {
			super();
			this.idx = idx;
			this.n = n;
		}
	}
	
}
