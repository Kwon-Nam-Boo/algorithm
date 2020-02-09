package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M1 {
	
	private static int Num;
	private static int Count;
	private static int[] result;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Num = Integer.parseInt(st.nextToken());
		Count = Integer.parseInt(st.nextToken());
		result = new int[Count];
		visited = new boolean[Num];
		permutation(0);
		System.out.println(sb);
	}
	
	public static void permutation(int d) {
		if(d == Count) {								// 깊이가 개수와 같으면 출력
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < Num; i++) {
			if(!visited[i]) {						// 방문한적이 없다면 방문 표시
				visited[i] =true;
			}else {									// 방문한적이 있다면 패스한다.
				continue;
			}
			result[d] = i+1;						// 현재 숫자 입력
			permutation(d+1);						// 깊이 증가해서 재귀
			visited[i] =false;						// 끝나고 돌아오면 방문 기록 삭제
			}
	}
	
}
