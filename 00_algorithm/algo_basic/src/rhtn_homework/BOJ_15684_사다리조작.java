package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15684_사다리조작 {
	
	// 세로선의 개수 N, 가로선의 개수 M, 세로선마다 가로선을 놓을 수 있는 위치의 개수 H
	private static int N,M,H,ans,line;
	private static int[][] ladder;
	private static boolean end;

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		ladder = new int[H][N-1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			ladder[a][b] = 1;
		}
		ans =-1;
		end = false;
		for (int i = 0; i <= 3; i++) {
			line = i;
			dfs(0,0);
			if(end) break;
		}
		System.out.println(ans);
	}
	
	private static void dfs(int x, int d) {
		if(end) return;
		
		if(d == line) {
			if(testLadder()) {
				ans = line;
				end = true;
			}
			return;
		}
		for (int i = x; i < H; i++) {
			for (int j = 0; j < N-1; j++) {
				// 범위를 벗어나거나
				if(ladder[i][j] == 0  && (j-1<0||ladder[i][j-1] == 0) && (j+1 == N-1 || ladder[i][j+1] == 0)){
					ladder[i][j] = 1;
					dfs(x,d+1);
					ladder[i][j] = 0;
				}
			}
		}
	}

	private static boolean testLadder() {
		// 원래는 스왑으로 해결하였으나, 그경우는 전체를 다해봐야 알기 때문에 하나씩 확인하는걸로 변경
		for (int i = 0; i < N; i++) {
			int c = i;
			for (int j = 0; j < ladder.length; j++) {
				if(c-1 >= 0 && ladder[j][c-1] == 1) c--;
				else if(c!= N-1 && ladder[j][c] == 1) c++;
			}
			if(c!=i) return false;
		}	
		return true;
	}
}
