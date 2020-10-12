package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15565_귀여운라이언 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] doll = new int[N];
		int rion = 0, cnt=0, ans = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			doll[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = -1;
		
		for (int i = 0; i < N; i++) {
			if(left>-1) cnt++;
			// 만약 라이언 인형이라면
			if(doll[i]==1) {
				// 근데 아직 시작값이 안정해져있다면
				if(left == -1) {
					left = i;
					cnt++;
				}
				rion++;
				if(rion == K) {
					// 현재의 길이가 가장 짧으면 답으로 ..
					ans = Math.min(ans, cnt);
					// 이젠 라이언 하나는 안녕 ..
					rion--;
					// 다음 가장 가까운 라이언으로 
					while(left<i) {
						left++;
						cnt--;
						if(doll[left] == 1) break;
					}
				}
			}
		}
		System.out.println(ans == Integer.MAX_VALUE ? -1: ans);
	}
}
