package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터_큐 {

	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			Queue<Pair> queue = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					
					return o2.compareTo(o1);
				}
			});
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				queue.offer(new Pair(i,tmp));
				pq.offer(tmp);
			}
			
			cnt = 0;
			while(!queue.isEmpty()) {
				Pair tmp = queue.poll();
				
				// 만약 pq 보다 크거나 같다면? 빼줘야지~
				if(pq.peek() <= tmp.num) {
					pq.poll();
					cnt++;
					if(tmp.idx == M) break;
				}else {
					queue.offer(tmp);
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	
	public static class Pair{
		int idx, num;

		public Pair(int idx, int num) {
			super();
			this.idx = idx;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Pair [idx=" + idx + ", num=" + num + "]";
		}
		
	}
}
