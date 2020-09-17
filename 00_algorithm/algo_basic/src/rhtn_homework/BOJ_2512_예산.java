package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512_예산 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int start = 0;
		int end = 0;
		int ans = 0;
		int mid = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			// 배열 중 가장 큰 수보다 답은 클수가 없다(가지치기)
			end = Math.max(arr[i], end);
		}
		int M = Integer.parseInt(br.readLine());
		
		while(start <=end) {
			int cnt =0;
			mid = (start + end) / 2;
			
			for (int i = 0; i < arr.length; i++) {
				if(mid< arr[i]) cnt+=mid;
				else cnt+=arr[i];
			}
			// 딱 예산 만큼 썻다면 답이지~
			if(cnt == M) {
				ans = mid;
				break;
			}else if(cnt > M) {	// 예산초과 인경우, 작은값중에서 이분탐색
				end = mid-1;
			}else {				// 예산 부족인경우, 큰값중에서 이분탐색 (답은 예산보다 작아야하므로 현재값을 일단 ans로 갱신)
				ans = mid;
				start = mid+1;
			}
		}
		System.out.println(ans);
	}
}
