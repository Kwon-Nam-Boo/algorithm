package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5052_전화번호_목록 {

	private static StringBuilder sb = new StringBuilder();
	private static int N, idx, maxL, visitCnt;	// N:전화번호 목록수		idx:인덱스 	maxL:전화번호 최대길이	visitCnt:체크된수
	private static boolean ans; // ans:답
	private static String[] arr;	// 전화번호 목록
	private static boolean[] check; 	// 방문 체크
	private static int[] overlap;	// 해당 번호 개수 저장
	private static int[] milestone;	// 해당 번호를 가진 값의 위치
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < TC; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new String[N];
			
			maxL = 0;
			check = new boolean[N];
			visitCnt = 0;
			
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine();
				maxL = Math.max(maxL, arr[i].length());
			}
			
			idx=0;
			ans = true;
			
			while(idx < maxL) {
				overlap = new int[10];		// 초기화
				milestone = new int[10];
				
				for (int i = 0; i < N; i++) {
					if(check[i]) continue;
					if(idx == arr[i].length()) {	// 해당 길이까지 도달한게 있다면 전화가 걸린것!, 일관성이 없다
						ans = false;
						break;
					}
					
					overlap[arr[i].charAt(idx) -'0']++;	// 해당 번호 개수 확인을 위해 저장
					milestone[arr[i].charAt(idx)-'0'] = i;	// 해당 번호 idx를 저장, 여러개면 갱신되지만 조사안할거라 ㄱㅊ
				}
				if(!ans) break;
				
				for (int i = 0; i <= 9; i++) {
					if(overlap[i] == 1) {	// 중복된 케이스가 없다면
						check[milestone[i]] = true;
						visitCnt++;
					}
				}
				if(visitCnt == N) break;
				idx++;
			}
			if(ans) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb);
		
		
	}
}
