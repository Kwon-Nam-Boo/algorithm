package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {
	
	private static int N;
	private static int min;
	private static int cx,cy,hx,hy;
	private static Pair[] cus;
	private static Pair[] result;
	private static boolean[] visited;
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			N = Integer.parseInt(br.readLine());
			cus = new Pair[N];
			result = new Pair[N+2];
			visited = new boolean[N];
			st = new StringTokenizer(br.readLine());
			cx = Integer.parseInt(st.nextToken());
			cy = Integer.parseInt(st.nextToken());
			result[0] = new Pair(cx,cy);							// 시작 배열
			hx = Integer.parseInt(st.nextToken());
			hy = Integer.parseInt(st.nextToken());
			result[N+1] = new Pair(hx,hy);							// 정답을 구할 배열
			
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				cus[j] = new Pair(a,b);
			}
			min = Integer.MAX_VALUE;
			dfs(1,0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int index, int sum) {
		if(index == N+1) {
			min = Math.min(min, sum + getLen(index));
			return;
		}if(sum>=min) {
			return;
		}
		for (int i = 0; i < cus.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[index]=cus[i];
				dfs(index+1,sum+getLen(index));
				visited[i] = false;
			}
		}
	}
	
	public static int getLen(int index) {
		return Math.abs(result[index].x- result[index-1].x) +  Math.abs(result[index].y- result[index-1].y);
	}
	
	public static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
	}
	
	

}
