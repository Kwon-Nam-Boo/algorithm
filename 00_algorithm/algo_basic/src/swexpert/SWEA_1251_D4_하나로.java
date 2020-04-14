package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;



public class SWEA_1251_D4_하나로 {
	
	private static int N;
	private static double min;
	private static double E;
	private static int[][] island;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC =Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			island = new int[N][2];
			visited = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int r = 0; r < N; r++) {
				island[r][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				island[c][1] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			min = 0;
			bfs(new Pair(0,0));
			sb.append(Math.round(min)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs(Pair start) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(start);
		
		int count =0;
		while(!pq.isEmpty()) {
			Pair tmp = pq.poll();
			// 방문한 적이 잇는가?
			if(visited[tmp.i]) continue; 
			// 방문처리
			visited[tmp.i] = true;
			//System.out.println(Arrays.toString(visited));
			// 길이 합치기
			min+=tmp.d;
			// 이미 n-1개의 간선을 다 확인햇으면 종료
			if(count ==N-1) return;
			for (int i = 1; i < N; i++) {
				if(!visited[i]) {
					double dis = Math.sqrt(Math.pow(island[i][0]-island[tmp.i][0], 2)+Math.pow(island[i][1]-island[tmp.i][1], 2));
					pq.offer(new Pair(i,dis*dis*E));
				}
			}
			System.out.println(pq);
			count++;

		}
	}
	
	//
	public static class Pair implements Comparable<Pair>{		// i: 정점의 index, d: 길이의 합
		int i;
		double d;
		
		public Pair(int i, double d) {
			this.i =i;
			this.d = d;
		}
		
		@Override
		public String toString() {
			return "Pair [i=" + i + ", d=" + d + "]";
		}

		@Override
		public int compareTo(Pair o) {
			Double d1 = this.d;
			Double d2 = o.d;
			return d1.compareTo(d2);
		}
		
	}
}
