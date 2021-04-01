package rhtn_homework;

import java.util.*;

public class BOJ_17071_숨바꼭질5 {

	public static void main(String[] args) {
		int[][] dist = new int[500001][2];
		
		for (int i = 0; i < dist.length; i++) {
			dist[i][0] = dist[i][1] = -1;
		}
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		if(N ==K) {
			System.out.println(0);
			System.exit(0);
		}
		Queue<Pair> queue = new LinkedList<>();
		// 0 은 짝수  1은 홀수
		queue.offer(new Pair(N,0));
		dist[N][0] = 0;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			
			for (int y : new int[]{p.n+1,p.n-1,2*p.n}) {
				if(y>=0 && y<=500000) {
					// 1초 후이므로 홀짝이 바뀔것이다
					if(dist[y][1-p.d] == -1) {
						dist[y][1-p.d] = dist[p.n][p.d]+1;
						queue.offer(new Pair(y,1-p.d));
					}
				}
			}
		}
		
		int ans = -1;
		for(int t = 0;;t++) {
			K+=t;
			if(K>500000) break;
			if(dist[K][t%2] <=t) {
				ans =t;
				break;
			}
		}
		System.out.println(ans);
	}

	private static class Pair{
		int n, d;

		public Pair(int n, int d) {
			super();
			this.n = n;
			this.d = d;
		}
		
	}
}
