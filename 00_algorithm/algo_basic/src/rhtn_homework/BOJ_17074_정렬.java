package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17074_정렬 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		int idx = -1;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[i-1]) {
				cnt++;
				idx = i;
			}
		}

		if(cnt == 0) {
			System.out.println(arr.length);
		}else if(cnt ==1) {
			int ans = 0;
			// 현재위치 한칸 앞의 값을 지울 경우
			// 만약 idx가 1이하의 숫자라면 idx-1을 지우면 정렬이 완성된다 
			if(idx > 1) {
				// 허나 1이상일 경우 idx-2와 idx번째의 수가 정렬되어있는지 비교해야한다
				if(arr[idx-2]<= arr[idx]) ans++;
			}else {
				ans++;
			}
			// 현재 위치의 값을 지울 경우
			// 가장 끝에 있는 N-1번째가 idx일 경우는 해당 숫자를 지움으로 정렬이 완성된다
			if(idx == N -1) {
				ans++;
			}else {
				// 하지만 그렇지 않다면  앞 뒤값의 크기를 비교해봐야 할것이다.
				if(arr[idx-1] <= arr[idx+1]) ans++;
			}
			System.out.println(ans);
		}else {
			System.out.println(0);
		}
	}

}
