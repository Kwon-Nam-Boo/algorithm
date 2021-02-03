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

public class BOJ_1043_거짓말 {
	
	private static int N,M,T;
	private static List<Integer> know;
	private static boolean[] visit; 
	private static int[][] party;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		know = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			know.add(Integer.parseInt(st.nextToken()));
		}
		
		party = new int[M][];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			party[i] = new int[len];
			for (int j = 0; j <len ; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new boolean[M];
		
		bfs();

		//System.out.println(know.contains(1));
	}

	private static void bfs() {
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i < T; i++) {
			queue.offer(know.get(i));
		}
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			
			for (int i = 0; i < party.length; i++) {
				for (int j = 0; j < party[i].length; j++) {
					// 만약 아는 사람이 있다면
					if(party[i][j] == p) {
						for (int j2 = 0; j2 < party[i].length; j2++) {
							// 그 파티에 아직 감염되지 않은 사람이면 감염 시킨다
							if(!know.contains(party[i][j2])) {
								know.add(party[i][j2]);
								queue.offer(party[i][j2]);
							}
						}
						visit[i] = true;
						break;
					}
				}
				//System.out.println(know);
			}
		}
		int ans = 0;
		for (int i = 0; i < party.length; i++) {
			if(!visit[i]) ans++;
		}
		System.out.println(ans);
	}

}
