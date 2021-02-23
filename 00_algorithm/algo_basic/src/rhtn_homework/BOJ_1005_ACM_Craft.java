package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005_ACM_Craft {
	
	private static int T,N,K,W;
	//val: 건물 시간, ed: 진입차수, ans: 가중치
	private static int[] val,ed,ans; 
	
	private static List<Integer>[] adlist;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			val = new int[N];
			for (int i = 0; i < N; i++) {
				val[i] = Integer.parseInt(st.nextToken());
			}
			
			adlist = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				adlist[i] = new ArrayList<>();
			}
			ed = new int[N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				adlist[x].add(y);
				ed[y]++;
			}
			W = Integer.parseInt(br.readLine())-1;
			
			// 정답은 우선 건물 짓는 시간을 초기화(해당점이 도착점일수 있기 때문에)
			ans = new int[N];
			for (int i = 0; i < N; i++) {
				ans[i] = val[i];
			}
			// 위상 정렬
			topologySort();
			
			sb.append(ans[W] +"\n");
		}
		System.out.println(sb);
	}


	private static void topologySort() {
		Queue<Integer> queue = new LinkedList<>();
		// 주의점: 진입차수가 0인것은 여러개일수 있다(즉, 시작점이 여러개..)
		for (int i = 0; i < ed.length; i++) {
			if(ed[i] ==0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			for (int i = 0; i < adlist[p].size(); i++) {
				int c = adlist[p].get(i);
				// 지난 가중치와 현재 건물짓는 시간 합이 가장 큰값이 현재 가중치가 된다
				if(ans[c] < val[c] + ans[p]) {
					ans[c] = val[c] + ans[p];
				}
				// 진입차수를 낮추고 만약 0이되면 큐에 합류
				ed[c]--;
				if(ed[c] == 0) {
					// 해당점이 구하는 값이면 미리 끝내자
					if(c == W) return;
					queue.add(c);
				}
			}
		}
		
	}
	

}
