package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기2_프림_리스트 {
	
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int R,C, islandIdx;
	private static int[][] map;
	private static List<Line>[] graph;
	private static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. 섬 구분하기
		islandIdx = 2;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 1) {
					bfs(new Pair(r,c));
					islandIdx++;
				}
			}
		}
		/*for (int[] a : map) {
			System.out.println(Arrays.toString(a));
		}*/
		
		// 2. 연결 리스트(그래프) 제작하기
		graph = new ArrayList[islandIdx-2];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 3. 그래프 완성하기
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] > 1) {
					makeGraph(new Pair(r,c));
				}
			}
		}
		/*for (List<Line> a : graph) {
			System.out.println(a);
		}*/
		System.out.println(prim());
		
	}
	
	
	private static int prim() {
		boolean[] check = new boolean[islandIdx-2];
		int[] key = new int[islandIdx-2];
		int[] p = new int[islandIdx-2];
		
		Arrays.fill(key, INF);
		
		p[0]=-1;
		key[0] = 0;
		
		for (int i = 0; i < islandIdx-3; i++) {
			int min = INF;
			int index = -1;
			
			for (int j = 0; j < key.length; j++) {
				if(!check[j] && key[j]< min) {
					min = key[j];
					index = j;
				}
			}
			if(index == -1) {
				return -1;
			}
			check[index] =true;
			
			for (int j = 0; j < graph[index].size(); j++) {
				Line child = graph[index].get(j);
				if(!check[child.n] &&  child.w < key[child.n]) {
					key[child.n] =child.w;
					p[child.n] = index;
				}
			}
		}
		int result =0;
		for (int i = 0; i < key.length; i++) {
			if(key[i] == INF) {
				return -1;
			}
			result+=key[i];
		}
		/*System.out.println(Arrays.toString(p));
		System.out.println(Arrays.toString(key));*/
		return result;
	}


	private static void makeGraph(Pair p) {
		int base = map[p.x][p.y];
		
		for (int i = 0; i < dir.length; i++) {
			for (int l = 1;; l++) {
				int nr = dir[i][0]*l + p.x;
				int nc = dir[i][1]*l + p.y;	
				
				if(!isIn(nr,nc) || map[nr][nc] == base){
					break;
				}else if(map[nr][nc] == 0) {
					continue;
				}else {
					if(l>2) {
						boolean flag = true;
						for (int j = 0; j < graph[base-2].size(); j++) {
							if(graph[base-2].get(j).n == map[nr][nc]-2) {
								graph[base-2].get(j).w = Math.min(graph[base-2].get(j).w,l-1);
								flag = false;
								break;
							}
						}
						if(flag) {
							Line l1 = new Line(map[nr][nc]-2 , l-1);
							graph[base-2].add(l1);
						}else {
							break;
						}	
					}
					break;
				}
			}
		}
		
	}



	private static void bfs(Pair p) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(p);
		map[p.x][p.y] = islandIdx;
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int nr = dir[i][0] + tmp.x;
				int nc = dir[i][1] + tmp.y;
	
				if(isIn(nr,nc) && map[nr][nc] == 1) {
					queue.offer(new Pair(nr,nc));
					map[nr][nc] = islandIdx;
				}
			}
		}
		
	}
	
	public static boolean isIn(int r, int c) {
		return r>= 0 && c>=0 && r < R && c < C;
	}


	public static class Pair{
		int x,y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
	public static class Line{
		int n,w;

		public Line(int n, int w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Line [n=" + n + ", w=" + w + "]";
		}
	
	}
	
	static String src = "7 8\r\n" + 
			"0 0 0 0 0 0 1 1\r\n" + 
			"1 1 0 0 0 0 1 1\r\n" + 
			"1 1 0 0 0 0 0 0\r\n" + 
			"1 1 0 0 0 1 1 0\r\n" + 
			"0 0 0 0 0 1 1 0\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"1 1 1 1 1 1 1 1";

}
