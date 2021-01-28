package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1039_교환 {
	
	private static int N, K;
	private static Queue<Integer> queue;
	private static boolean[][] visited  = new boolean[1000001][11];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
	}

	private static void bfs() {
		
		queue = new LinkedList<>();
		queue.offer(N);
		
		for (int i = 0; i < K; i++) {
			int cnt = queue.size();
			for (int j = 0; j < cnt; j++) {
				int num = queue.poll();
				swap(num, i);
			}
		}
		
		int max = -1;
		
		// 큐가 비었다면 당연히 -1, 아니라면 최대값 출력
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			max = Math.max(tmp, max);
		}
		System.out.println(max);
		
	}

	private static void swap(int num, int c) {
		
		int size = (int) (Math.log10(num)+1);
		
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				if(i == j) continue;
				
				// i와 j를 교체한다
				StringBuilder sb = new StringBuilder();
				sb.append(num);

				// 0이 맨앞으로 오는경우는 예외처리해줘야지
				if(i == 0 && sb.charAt(j) == '0') {
					continue;
				}
					
				char tmp = sb.charAt(i);
				sb.setCharAt(i, sb.charAt(j));
				sb.setCharAt(j, tmp);
				int change = Integer.parseInt(sb.toString());
				
				if(!visited[change][c]) {
					queue.offer(change);
					visited[Integer.parseInt(sb.toString())][c] = true;
				}else continue;
			}
		}
		
	}

}
