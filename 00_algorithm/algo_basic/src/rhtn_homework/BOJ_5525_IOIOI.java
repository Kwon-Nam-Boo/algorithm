package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5525_IOIOI {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int len = Integer.parseInt(br.readLine());
		String word = br.readLine();
		
		// n = 1 -> ioi 한번  , n = 2 -> ioi 두번 (ioi 횟수 = n)
		// ioi가 나온 횟수
		int ioiCount =0;
		int ans = 0;
		
		for (int i = 0; i < len-2; i++) {
			// ioi가 나왓다면
			if(word.charAt(i) == 'I' && word.charAt(i+1) == 'O' && word.charAt(i+2) == 'I') {
				ioiCount++;
				if(N == ioiCount) {
					ans++;
					ioiCount--;
				}
				i++;
			}else {	//ioi가 안 나왓다면
				ioiCount = 0;
			}
		}
		System.out.println(ans);
	}
}
