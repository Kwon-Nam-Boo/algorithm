package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11967_불켜기 {

	private static int N,M;
	private static List<Integer>[] adlist;
	private static boolean[] light, visited;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adlist = new ArrayList[N*N];
		for (int i = 0; i < adlist.length; i++) {
			adlist[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken())-1;
			int sy = Integer.parseInt(st.nextToken())-1;
			int ex = Integer.parseInt(st.nextToken())-1;
			int ey = Integer.parseInt(st.nextToken())-1;
			adlist[sx*N + sy].add(ex*N+ey);
		}
		light = new boolean[N*N];
		visited = new boolean[N*N];

		
//		for (int i = 0; i < adlist.length; i++) {
//			System.out.println(adlist[i]);
//		}
		
		System.out.println(bfs());
	}

	private static int bfs() {
		int cnt = 1;
		Queue<Integer> queue = new LinkedList<>();
		// 방문하지않은 불켜진방
		Queue<Integer> check = new LinkedList<>();
		queue.offer(0);
		light[0] = true;
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			
			// 일단 불켜기 ..
			for (int i = 0; i < adlist[p].size(); i++) {
				int nextLight = adlist[p].get(i);
				if(!light[nextLight]) {
					light[nextLight] = true;
					cnt++;
					check.offer(nextLight);
				}
			}
			int len = check.size();
		
			for (int i = 0; i < len; i++) {
				int c = check.poll();
				int cr = c/N;
				int cc = c%N;
				
				boolean test = false;
				// 방문하기 ..
				for (int j = 0; j < dir.length; j++) {
					int nr = cr + dir[j][0];
					int nc = cc + dir[j][1];
					int next = nr*N +nc;
					
					if(isIn(nr,nc) && visited[next]) {
						queue.offer(c);
						visited[c] = true;
						test =true;
					}
				}
				if(!test) check.offer(c);
			}
	
		}
		return cnt;
	}
	
	public static boolean isIn(int r, int c){
		return r>=0 && c>=0 && r<N && c<N;
	}
}
