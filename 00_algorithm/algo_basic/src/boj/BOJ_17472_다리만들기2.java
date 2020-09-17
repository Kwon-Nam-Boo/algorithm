package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리만들기2 {
	
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int N;
	private static int M;
	private static int[][] graph;
	private static int[][] map;
	private static int island;
	private static int INF = Integer.MAX_VALUE;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		// 입력값 받기
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1.섬을 구분해주기
		island = 2;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map[r][c] == 1) { // 새로운 섬을 발견했다면?
					bfs(r,c);
					island++;
				}
			}
		}
		/*for (int[] a : map) {
		System.out.println(Arrays.toString(a));
		}*/
		
		
		// 2. 그래프 구성하기
		graph = new int[island][island];
		for (int i = 2; i < island; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		
		//3. 각 섬별로 거리 찾기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] > 1) {
					makeGraph(r, c);
				}
			}
		}
		for (int[] a : graph) {
			System.out.println(Arrays.toString(a));
		}
		
		
		System.out.println(prim());
		
		
		
	}
	
	private static void bfs(int r, int c) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(r,c));
		
		map[r][c] = island;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int pr = dir[i][0] + p.r;
				int pc = dir[i][1] + p.c;
				
				if(isIn(pr,pc) && map[pr][pc] == 1) {
					map[pr][pc] = island;
					queue.offer(new Pair(pr,pc));
				}
			}
		}
		
	}

	private static void makeGraph(int r, int c) {
		int here = map[r][c];
		
		for (int i = 0; i < dir.length; i++) {
			for (int l = 1; ; l++) {
				int nr = dir[i][0]*l + r;
				int nc = dir[i][1]*l + c;
				
				// map안 에 있다면
				if(isIn(nr,nc)) {
					if(map[nr][nc] == 0) {
						continue;
					}else if(map[nr][nc] == here) {	// 자기와 같은걸 만나면 무필요
						break;
					}else {
						if(l>2){
							graph[here][map[nr][nc]] = graph[map[nr][nc]][here] = Math.min(graph[here][map[nr][nc]], l-1);
						}
						break;
					}
					
				}else { // map안에 없다면
					break;
				}
			}
		}
		
	}


	private static int prim() {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		Vertex[] v = new Vertex[island];
		for (int i = 2; i < island; i++) {
			if(i == 2) {
				v[i] = new Vertex(i, 0);
			}else {
				v[i] = new Vertex(i, INF);
			}
			pq.offer(v[i]);
		}
		
		int sum = 0;
		
		while(!pq.isEmpty()) {
			Vertex front = pq.poll();
			
			if(front.key == INF) {
				return -1;
			}
			sum+=front.key;
			// 가장 가까운 비용으로 업그레이드
			for (int i = 2; i < island; i++) {
				Vertex child = v[i];
				// 불러온게 아직도 pq에 있는가? 아직 들른 적이 없다
				if(pq.contains(child)) {
					if(child.key > graph[front.idx][i]) {
						child.key = graph[front.idx][i];
						pq.remove(child);
						pq.offer(child);
					}
				}
			}
		}
		return sum;
	}


	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r< N && c< M;
	}
	
	public static class Pair{
		int r,c;
		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static class Vertex implements Comparable<Vertex>{
		int idx;
		int key;
		
		public Vertex(int idx, int key) {
			super();
			this.idx = idx;
			this.key = key;
		}

		@Override
		public int compareTo(Vertex o) {
			Integer k1 = this.key;
			Integer k2 = o.key;
			return k1.compareTo(k2);
		}
		
	}
}
