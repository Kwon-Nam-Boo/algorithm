package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15685_드래곤커브 {

	private static StringBuilder sb = new StringBuilder();
	private static int N,cnt;
	private static int map[][];
	private static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[101][101];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragonCurve(y,x,d,g);
		}
		cnt = 0;
		checkSquare();
		System.out.println(cnt);
	}
	// 사각형인 경우를 카운트
	private static void checkSquare() {
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if(map[r][c] == 1 && map[r][c+1] == 1 && map[r+1][c] == 1 && map[r+1][c+1] == 1) cnt++;
			}
		}
	}

	private static void dragonCurve(int x, int y, int d, int g) {
		List<Integer> list = new ArrayList<>();
		list.add(d);
		// 한세대를 추가 할때는 현재 세대의 역순을 좌회전 시켜서 추가하면된다
		for (int i = 0; i < g; i++) {
			for (int j = list.size()-1; j >=0 ; j--) {
				list.add((list.get(j)+1)%4);
			}
		}
		map[x][y] = 1;
		int tx = x;
		int ty = y;
		// 드래곤 커브가 된점을 체크
		for (int i = 0; i < list.size(); i++) {
			 int td = list.get(i);
			 tx = dir[td][0] + tx;	
			 ty = dir[td][1] + ty;
			 map[tx][ty]=1;
		}
	}

	
}


