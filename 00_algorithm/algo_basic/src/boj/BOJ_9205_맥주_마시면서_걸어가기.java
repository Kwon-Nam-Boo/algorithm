package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_맥주_마시면서_걸어가기 {
	
	private static int PC;
	private static boolean[] visited;
	private static boolean flag;
	private static Pair[] place;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC =Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			
			PC = Integer.parseInt(br.readLine()) + 2;
			place = new Pair[PC];
			for (int j = 0; j < PC; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				place[j] = new Pair(x,y);
			}
			visited = new boolean[PC];
			flag = false;
			bfs();
			if(flag) {
				sb.append("happy").append("\n");
			}else {
				sb.append("sad").append("\n");
			}
		}
		System.out.println(sb);
		
	}
	public static void bfs() {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(place[0]);
		visited[0] =true;
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			// 종료 조건
			if(tmp.x == place[PC-1].x && tmp.y == place[PC-1].y) {
				flag =true;
				return;
			}
			for (int i = 1; i < place.length; i++) {
				int dis = Math.abs(tmp.x - place[i].x) + Math.abs(tmp.y - place[i].y);
				if(!visited[i] && dis <= 1000) {
					queue.offer(place[i]);
					visited[i] = true;
				}
			}
		}
	}
	
	public static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
