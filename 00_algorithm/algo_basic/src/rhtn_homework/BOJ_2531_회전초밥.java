package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2531_회전초밥 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		// 회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
	
		// 접시들
		int[] dish = new int[N];
		// 초밥 종류
		int[] sushi = new int[d+1];
		int ans;
		
		for (int i = 0; i < dish.length; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}
		
		// 1. 초기화
		// 쿠폰번호 스시 카운트
		sushi[c]++;
		// 먹은 스시 종류의 개수(기본값은 쿠폰)
		int cnt = 1;
		
		// (0 ~ k-1)까지 스시를 카운트
		for (int i = 0; i < k; i++) {
			// 스시를 먹은적 없다면 ? 종류 개수 증가
			if(sushi[dish[i]] == 0) cnt++;
			// 먹은 스시 종류 개수 증가
			sushi[dish[i]]++;
		}
		ans = cnt;
		
		// 2. 한 바퀴 돌면서 각 포지션에서의 cnt를 구한다
		for (int i = 1; i < N; i++) {
			// 이전 그릇 카운트를 빼주고
			sushi[dish[i-1]]--;
			// 해당 카운트가 0 이면 , 먹은 스시 종류는 감소
			if(sushi[dish[i-1]] == 0) {
				cnt--;
			}
			// 들어온 그릇카운트를 올린다
			sushi[dish[(i+k-1) % N]]++;
			// 카운트가 1이면(방금 넣은 카운트밖에 없다면), 먹은 스시 종류는 증가
			if(sushi[dish[(i+k-1) % N]] == 1) {
				cnt++;
			}
			// 3. 가장 큰 cnt는 답이 될 것이다
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	
	}
}
