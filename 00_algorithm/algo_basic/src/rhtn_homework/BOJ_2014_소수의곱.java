package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2014_소수의곱 {
	
	private static int K, N;
	private static long[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new long[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		findN();
	}

	private static void findN() {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < K; i++) {
			pq.add(arr[i]);
		}
		
		for (int i = 0; i < N-1; i++) {
			long p = pq.poll();
			
			for (int j = 0; j < K; j++) {
				pq.add(p*arr[j]);
				// p 가 해당하는 소수들로 이루어진 숫자라면 뒤의 과정은 굳이 할 필요가 겂다
				if(p % arr[j] == 0) break;
			}
			//System.out.println(pq);
		}
		System.out.println(pq.poll());		
	}

}
