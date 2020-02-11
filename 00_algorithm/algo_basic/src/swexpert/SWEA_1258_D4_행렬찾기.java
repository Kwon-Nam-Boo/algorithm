package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1258_D4_행렬찾기 {

	private static int N;	
	private static int H;	
	private static int W;	
	private static int count;
	private static List<Pair> re;
	
	private static int[][] map;
	private static int[][] visited;
	private static int[][] dir= {{-1,0},{1,0},{0,-1},{0,1}}; //상 하 좌 우
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new int[N][N];
			H =0;
			W =0;
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			count =0;
			re = new ArrayList<Pair>();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c]>0 && visited[r][c]==0) {		// 만약 map에는 존재하지만 방문한적이 없다면?
						bfs(r,c);								// 새로운 박스를 발견
						re.add(new Pair(H,W));					
						count++;								// 박스의 높이, 너비값을 추출하고 개수를 한개 증가
						H =0;
						W =0;
					}
				}
			}
			
			Collections.sort(re);								
			sb.append(count).append(" ");
			for (int j = 0; j < re.size(); j++) {
				sb.append(re.get(j).x).append(" ").append(re.get(j).y).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
			
			
	}
	public static class Pair implements Comparable<Pair>{		// 두가지 용도로 쓰임
		int x;													// 1. 행과 열의 페어값 	2. H W의 넓이 정렬을 위한 compare
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
		@Override									// 높이, 너비 정렬 값
		public int compareTo(Pair o) {				// 넓이 비교 하고 같은 넓이면  높이가 작은 값으로 정렬
			Integer a = this.x;
			Integer b = o.x; 
			Integer area1 = this.x * this.y;
			Integer area2 = o.x * o.y;
			if(area1.equals(area2)) {
				return a.compareTo(b);
			}
			return area1.compareTo(area2);
		}
		
	}
	public static void bfs(int r, int c) {					// bfs 사용
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(r,c));
		visited[r][c] = 1 ;
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			
			for (int i = 0; i < dir.length; i++) {			
				int nx = tmp.x + dir[i][0];
				int ny = tmp.y + dir[i][1];
				
				if(i ==1 && ny == c && (!isIn(nx,ny) || map[nx][ny]==0)){		// 시작 열값이면서, 밑으로 내려가는데 벽이나 0을 만나면
					H = visited[tmp.x][tmp.y];									// 현재 값은 높이가 됩니다.
				}
				if(i ==3 && nx == r && (!isIn(nx,ny) || map[nx][ny]==0)){		// 시작 행값이면서 , 우측으로 가는데 벽이나 0을 만나면
					W = visited[tmp.x][tmp.y];									// 현재 값은 너비가 됩니다.
				}
				
				if(isIn(nx,ny) && map[nx][ny]>0 && visited[nx][ny] ==0) {
					queue.offer(new Pair(nx,ny));
					visited[nx][ny] =visited[tmp.x][tmp.y] +1;					// vistied는 각 박스의 최단거리 값을 저장하게 됩니다.
				}
			}
		}
	
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c >=0 && r< N && c< N;
	}

	
}
