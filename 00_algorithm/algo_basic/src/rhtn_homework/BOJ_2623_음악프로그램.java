package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2623_음악프로그램 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] count = new int[N+1]; 
		List<Integer>[] list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int tmp = Integer.parseInt(st.nextToken());
			for (int j = 1; j < c; j++) {
				int tmp2 = Integer.parseInt(st.nextToken());
				// 인접리스트를 만들고
				list[tmp].add(tmp2);
				tmp = tmp2;
				// 해당 점에 들어오는 요소들의 수를 카운트
				count[tmp2]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		// 카운트가 0 인것을 queue에 넣는다
		for (int i = 1; i < count.length; i++) {
			if(count[i] == 0) queue.offer(i);
		}

		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			// 큐에서 나온 순서대로 정렬
			sb.append(now).append("\n");
			
			cnt++;
			for (int i = 0; i < list[now].size(); i++) {
				int tmp = list[now].get(i);
				// 해당 점으로 들어오는 점이 이미 정렬 완료 햇으므로 한개 뺴준다
				count[tmp]--;
				// 해당 점이 0이 되면 큐에 넣는다
				if(count[tmp] == 0) {
					queue.offer(tmp);
				}
			}
		}
		// 답이 안나오는경우는 0 출력
		if(cnt !=N) {
			System.out.println(0);
		}else
		System.out.println(sb);
		
	}
}
