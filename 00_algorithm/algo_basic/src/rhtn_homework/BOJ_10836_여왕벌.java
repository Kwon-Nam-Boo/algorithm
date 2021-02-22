package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10836_여왕벌 {
	
	private static int N,M,edge;
	private static int[][] day, map;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		day = new int[N][3];
		map = new int[M][M];
		edge = 2*M-1;
		
		for (int i = 0; i < M; i++) {
			Arrays.fill(map[i], 1);
		}
	
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			day[i][0] = Integer.parseInt(st.nextToken());
			day[i][1] = Integer.parseInt(st.nextToken());
			day[i][2] = Integer.parseInt(st.nextToken());
		}
		// 1.모서리 수정
		changeEdge();
		// 2. 내부수정(문제에서는 1->2를 반복해야하지만 , 사실 1만 진행하고 마지막만 2를 진행하면된다)
		changeInside();
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < M; c++) {
				sb.append(map[r][c] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void changeInside() {
		
		for (int r = 1; r < M; r++) {
			for (int c = 1; c < M; c++) {
				int tmp = Math.max(map[r-1][c], map[r][c-1]);
				map[r][c] = Math.max(map[r][c], tmp);
			}
		}
		
	}

	private static void changeEdge() {

		for (int x = 0; x < N; x++) {
			boolean end  = false;
			int cnt = 0;
			int w = day[x][cnt];
			
			for (int i = M-1; i >= 0; i--) {
				while(w == 0) {
					cnt++;
					w = day[x][cnt];
				}
				map[i][0]+=cnt;
				w--;
			}
			
			for (int i = 1; i < M; i++) {
				while(w ==0) {
					cnt++;
					if(cnt == 3) break;
					w = day[x][cnt];
				}
				map[0][i]+= cnt;
				w--;
			}

			// 2. 내부 수정
			//changeInside();
			
		}

	}

}
