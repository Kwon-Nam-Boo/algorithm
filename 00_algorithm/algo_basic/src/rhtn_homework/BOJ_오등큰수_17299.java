package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_오등큰수_17299 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int max;
		int[] arr = new int[n];
		int[] ans = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		
		arr[0] = Integer.parseInt(st.nextToken());
		max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i] =Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		// 각 숫자에 대한 카운트를 담은 배열 (나온 숫자중 가장 큰 값 +1 만큼 배열 생성)
		int[] coun = new int[max+1];
		// 카운팅
		for (int i = 0; i < arr.length; i++) {
			coun[arr[i]]++;
		}

		Stack<Pair> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			
			// 들어오는게 더 개수가 많다면? 오등큰수이다. 스택이 비거나 더 큰걸 만날때 까지는 그 모든게 오등큰수이다
			while(!stack.isEmpty() && coun[stack.peek().n] < coun[arr[i]]) {
				ans[stack.pop().idx] = arr[i];
			}
			
			stack.push(new Pair(i,arr[i]));
		}
		
		while(!stack.isEmpty()) {
			ans[stack.pop().idx] = -1;
		}
		
		for (int i = 0; i < ans.length; i++) {
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
