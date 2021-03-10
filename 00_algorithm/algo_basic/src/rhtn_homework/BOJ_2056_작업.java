package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2056_작업 {

	private static int N;
	private static int[] time,indegree,D;
	private static List<Integer>[] list;
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		time = new int[N];
		indegree = new int[N];
		list = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		Queue<Integer> queue = new LinkedList<>();
		D = new int[N];
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			// a->b 연결리스트 제작, b의 진입차수 카운팅
			for (int j = 0; j < p; j++) {
				int s = Integer.parseInt(st.nextToken())-1;
				list[s].add(i);
				indegree[i]++;
			}
			// 진입 차수가 0이면 시작점이므로 queue 추가
			if(indegree[i] == 0) {
				queue.offer(i);
				D[i] = time[i];
				ans = Math.max(ans, D[i]);
			}
		}

		while(!queue.isEmpty()) {
			int now = queue.poll();
			// 갈수 있는 점으로 방문(해당점의 진입차수제거) 후, 
			for (int next : list[now]) {
				indegree[next]--;
				D[next] = Math.max(D[next], D[now]+time[next]);
				ans = Math.max(ans, D[next]);
				//이동한점이 더이상 진입차수가 없다면, 다른점 이동이 가능하므로 queue추가
				if(indegree[next] == 0) queue.offer(next);
			}
		}
		System.out.println(ans);
		
	}
	
}
