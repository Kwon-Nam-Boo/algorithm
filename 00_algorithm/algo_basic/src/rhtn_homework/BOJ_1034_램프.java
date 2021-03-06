package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1034_램프 {
	
	private static int N, M, K;
	private static String[] stringMap;
	private static char[][] map;
	private static boolean possible[];

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		possible = new boolean[N];
		stringMap = new String[N];
		for (int i = 0; i < N; i++) {
			stringMap[i] = br.readLine();
			map[i] = stringMap[i].toCharArray();
		}
			
		K = Integer.parseInt(br.readLine());
		
		// 1. 불켜짐 가능 열 찾기
		for (int i = 0; i < N; i++) {
			int cnt =0;
			for (int j = 0; j < M; j++) {
				if(map[i][j] == '0') cnt++;
			}
			// 0의 횟수가 버튼 누른 횟수의 홀짝이 동일하고 , K보다 작다면 (해당 열은 불켜짐이 가능하다)
			// 즉, 해당조건이 안된다면 죽어도 불켜짐을 만족할수 없다
			if(cnt%2 == K%2 && cnt<=K){
				possible[i] = true;
			}
		}
		int max = 0;

		// 2. 불켜짐 가능한 열을 기준으로 max(ans)값 찾기 
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			if(possible[i]) {
				for (int j = 0; j < N; j++) {
					// 기준열과 다른열을 비교해서 같다면 모양이 같기에 같이 불켜짐이 된다
					if(stringMap[i].equals(stringMap[j])) cnt++;
				}
				max = Math.max(max, cnt);
			}
			
		}
		System.out.println(max);
	
	}

}
