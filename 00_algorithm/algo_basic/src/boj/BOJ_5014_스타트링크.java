package boj;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014_스타트링크 {
	
	private static int F; 			// 건물 높이
	private static int S; 			// 현재 층
	private static int G; 			// 도착 층
	private static int U; 			// U만큼 올라가기
	private static int D; 			// D만큼 내려가기
	private static int[] visited = new int[1000001];
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = -Integer.parseInt(st.nextToken());
		
		bfs(S);
		
		if(visited[G]-1 >= 0) {
			System.out.println(visited[G]-1);
		}else {
			System.out.println("use the stairs");
		}
		
	}
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start]=1;
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			if(tmp == G) {
				break;
			}
			for (int i = 0; i < 2; i++) {
				int a;
				if(i==0) {
					a = tmp + U;
				}else {
					a = tmp + D;
				}
				if(a >0 && a <= F && visited[a]==0) {
					queue.offer(a);
					visited[a] = visited[tmp]+1;
				}
			}
			
		}
	}
}
