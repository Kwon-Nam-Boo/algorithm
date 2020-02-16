package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리멘더링 {
	
	private static int N;									// 도시
	private static int[] people;							// 사람
	private static int count;								// 현재 선거구를 방문한 수
	private static List<Integer>[] graph;					// 그래프
	private static List<Integer> sub;						// 선거수 1
	private static List<Integer> sub2;						// 선거수 2
	private static boolean[] visited;						// 방문 기록
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());						
		people = new int[N+1];
		graph = new ArrayList[N+1];
		
		visited = new boolean[N+1];
		for (int i = 1; i < graph.length; i++) {			// 그래프 제작
			graph[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < people.length; i++) {
			people[i] = Integer.parseInt(st.nextToken());	// 사람 수 
		}
		
		for (int i = 1; i <= N; i++) {						// 그래프 제작
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				int b = Integer.parseInt(st.nextToken());
				graph[i].add(b);							// 입력 데이터 값이 이미 양방향이기 때문에 추가적으로 고려하지 않음
			}
		}
		subset();
		
	}
	
	/*public static void subset(int r, int k) {				// 재귀로 구하려고 했으나
		System.out.println(sub);
		
		if(r == N) {
			return;
		}
		
		for (int i = k; i <= N; i++) {
			sub.add(i);
			subset(r+1, i+1);
			sub.remove(sub.size()-1);
		}
	}*/

	public static void subset() {							// 부분 집합(선거 구1,2)를 찾고 인구수를 비교해서 답을 도출
		int min = Integer.MAX_VALUE;						// 최소 인구수 차이 (답)
		boolean flag = false;		
		
		for (int i = 1; i < 1<<(N-1); i++) {				// 2^n-1
			sub = new ArrayList<Integer>();
			sub2 = new ArrayList<Integer>();
			
			for (int j = 0; j < N; j++) {
				if((i & (1<<j))>0) {						// 선거구 1
					sub.add(j+1);
				}else {
					sub2.add(j+1);							// 선거구 2
				}
				
		}
		
		if(check(sub.get(0), sub) && check(sub2.get(0), sub2)) {	// 각각의 선거구가 가능하게 나눠진 케이스라면
			flag =true;
			int sum =0;												// 인구수를 따져서 계산해본다.
			for (int j = 0; j < sub.size(); j++) {
				sum+=people[sub.get(j)];
			}
			int sum2 =0;
			for (int j = 0; j < sub2.size(); j++) {
				sum2+=people[sub2.get(j)];
			}
			min = Math.min(min, Math.abs(sum-sum2));				// 인구수
		}
	}
		if(flag) {													// 플래그: 만약 선거구가 안나누어진다면
			System.out.println(min);							
		}else {
			System.out.println(-1);									// 불가능 : -1
		}
		

	}
	public static boolean check(int start ,List<Integer> sl) {		//   선거구의 시작값, 해당 선거구의 값들이 이어져있는지 확인
		if(sl.size() == 1) {										//  한개밖에 없으면 확인할 필요 없다.
			return true;
		}
		count = 1;
		for (int i = 0; i < visited.length; i++) {					//  방문 기록 초기화
			visited[i] =false;
		}
		Queue<Integer> queue = new LinkedList<>();					// bfs 탐색
		queue.offer(start);							
		visited[start] =true;										
		
		while(!queue.isEmpty()) {
			List<Integer> childs = graph[queue.poll()];
			for (int i = 0; i < childs.size(); i++) {
				int child =childs.get(i);
				if(sl.indexOf(child) > 0 && !visited[child]) {		// 해당 리스트에 존재하면서 , 방문한적이 없으면
					queue.offer(child);								
					visited[child] =true;							// 큐 추가, 방문 기록하고 , 카운트를 올려준다.
					count++;
				}
			}
		}
		if(count == sl.size()) {									// 해당 선거구의 크기 만큼 방문했으면
			return true;											// 해당 선거구는 모두 이어져 있다.
		}else {
			return false;
		}
		
	}

}
