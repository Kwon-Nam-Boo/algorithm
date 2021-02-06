package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_보석도둑 {

	private static int N,K;
	private static Pair[] jew;
	private static int[] bag;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		jew = new Pair[N];
		bag = new int[K];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jew[i] = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		// 보석, 가방 정렬(보석은 무게순으로)
		Arrays.sort(jew);
		Arrays.sort(bag);

		long ans = 0;
		int tmp = 0;
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				Integer p1 = o1.p;
				Integer p2 = o2.p;
				return p2.compareTo(p1);
			}
		});
		
		for (int i = 0; i < K; i++) {
			for (int j = tmp; j < N; j++) {
				// 만약 가방에 들어갈수 있다면 넣고 없다면 끝!
				if(jew[j].w <= bag[i]) {
					pq.offer(new Pair(jew[j].w, jew[j].p));
					tmp = j+1;
				}else break;
			}
			
			if(!pq.isEmpty()) {
				Pair p = pq.poll();
				ans+=p.p;
			}
			
		}
		System.out.println(ans);
	}
	
	public static class Pair implements Comparable<Pair>{
		int w,p;

		
		public Pair(int w, int p) {
			super();
			this.w = w;
			this.p = p;
		}

		@Override
		public int compareTo(Pair o) {
			Integer w1 = this.w;
			Integer w2 = o.w;
			Integer p1 = this.p;
			Integer p2 = o.p;
			
			if(w1 == w2) {
				return p2.compareTo(p1);
			}
			else
				return w1.compareTo(w2);
		}
	
	}
}
