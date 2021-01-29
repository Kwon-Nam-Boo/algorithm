package rhtn_homework;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = arr[0];
		
		// N개수보다 많은 수를 초기로, 만약 변하지 않았다면 0으로 출력하게 해준다
		int ans = N+1;
		
		while(start<N) {
			// 왼쪽점이 이동해야하는경우
			if(sum >= M || end == N-1) {
				sum-= arr[start];
				start++;
			// 오른쪽 점이 움직여야하는 경우
			}else if(sum < M) {
				end++;
				sum+=arr[end];
			}
			// ans 조건 확인
			if(sum >=M)
				ans = Math.min(end-start+1, ans);
		}
		
		if(ans == N+1) ans = 0;
		
		System.out.println(ans);
	}

}
