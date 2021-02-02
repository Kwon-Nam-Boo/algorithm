package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11003_최솟값찾기 {
	
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int L = Integer.parseInt(st.nextToken()); 
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		// 인덱스를 담을 DQ
		Deque<Integer> dq = new ArrayDeque<>();
		

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			// 만약 들어올 값보다 크다면 해당값을 버리는 걸 반복
			while(!dq.isEmpty() && arr[dq.peekLast()] > arr[i]) {
				dq.pollLast();
			}
			dq.offer(i);
			
			// 만약 인덱스가 주어진 범위보다 작은 숫자라면 없애주자
			if(i-L +1 > dq.peekFirst()) {
				dq.pollFirst();
			}
			
			sb.append(arr[dq.peekFirst()] +" ");
		}
		System.out.println(sb);
		
	}

}
