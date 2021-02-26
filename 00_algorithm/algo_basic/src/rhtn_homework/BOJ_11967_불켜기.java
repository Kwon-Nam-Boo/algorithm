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

		System.out.println(bfs());
	}

	private static int bfs() {
		int cnt = 1;
		
		Queue<Integer> queue = new LinkedList<>();
		// 방문하지않은 불켜진 방 확인
		Queue<Integer> check = new LinkedList<>();
		queue.offer(0);
		light[0] = true;
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			
			// 일단 불켜고 check에 추가
			for (int i = 0; i < adlist[p].size(); i++) {
				int nextLight = adlist[p].get(i);
				if(!light[nextLight]) {
					light[nextLight] = true;
					cnt++;
					check.offer(nextLight);
				}
			}
			
			int len = check.size();
			// check를 확인하면서 방문하기 ..
			for (int i = 0; i < len; i++) {
				
				int c = check.poll();
				int cr = c/N;
				int cc = c%N;
				
				boolean test = false;
				// check에서 꺼내온 방이, 이동할수 있는 곳이라면 ..? 이동하자
				for (int j = 0; j < dir.length; j++) {
					// next라고 했지만, 사실상 근처에 암소가 있을수 있는가 없는가를 찾는것
					int nr = cr + dir[j][0];
					int nc = cc + dir[j][1];
					int next = nr*N +nc;
					// 만약 현재까지의 위치에서 이동할수 있는 곳이라면 이동후 queue 삽입, 방문처리
					if(isIn(nr,nc) && visited[next]) {
						queue.offer(c);
						visited[c] = true;
						test =true;
					}
				}
				// 주의: 만약에 방문한경우가 없으면 다시 check에 넣어준다(이후 불켜지는것에따라 갈수도 있으니깐)
				if(!test) check.offer(c);
			}
	
		}
		return cnt;
	}
	
	public static boolean isIn(int r, int c){
		return r>=0 && c>=0 && r<N && c<N;
	}
}
