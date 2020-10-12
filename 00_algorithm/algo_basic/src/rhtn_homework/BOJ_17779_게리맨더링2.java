package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17779_게리맨더링2 {

	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int[][] map,ward;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		ward = new int[N+1][N+1];
		
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				check(r,c);
			}
		}
		System.out.println(ans);
	}

	private static void check(int x, int y) {
		int D = N-x;
		for (int i = 1; i <= D; i++) {
			int d1 = i;
			for (int j = 1; j <= D; j++) {
				int d2 =j;
				if(isIn(x,y,d1,d2)) {
					check4bound(x,y,d1,d2);
					boundary(x,y,d1,d2);
					putFive(x,y,d1,d2);
					countAndFind();
				}
			}
		}
	}
	// 시작하자마자 x,y,d1,d2를 기준으로 1,2,3,4 구역을 나눈다(사실상 초기화 작업)
	private static void check4bound(int x, int y, int d1, int d2) {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if(r>=1 && x+d1>r && 1<=c && c<=y) ward[r][c] =1;
				else if(r>=1 && x+d2>=r && y<c && c<=N) ward[r][c] =2;
				else if(r>=x+d1 && N>=r && 1<=c && c<y-d1+d2) ward[r][c] =3;
				else if(r>=x+d2 && N>=r && y-d1+d2<=c && c<=N) ward[r][c] =4;
			}
		}
	}
	// 경계를 나누자!
	private static void boundary(int x, int y, int d1, int d2) {
		for (int i = 0; i <= d1; i++) {
			ward[x+i][y-i] = 5;
		}
		for (int i = 0; i <= d2; i++) {
			ward[x+i][y+i] = 5;
		}
		for (int i = 0; i <= d2; i++) {
			ward[x+d1+i][y-d1+i] = 5;
		}
		for (int i = 0; i <= d1; i++) {
			ward[x+d2+i][y+d2-i] = 5;
		}
	}
	// 범위 내부에 있는 숫자를 5로 채운다
	private static void putFive(int x, int y, int d1, int d2) {
		
		for (int r = x+1; r < x+d1+d2; r++) {
			boolean flag = false;
			for (int c = 1; c <= N ; c++) {
				if(flag && ward[r][c] == 5) break;
				if(flag && ward[r][c] != 5) ward[r][c] = 5;
				if(!flag && ward[r][c] == 5) flag = true;
			}
		}
	}
	// 각 구역의 인구수를 세고 최고지역 최소지역간의 차가 제일 작은걸 찾는다
	private static void countAndFind() {
		int[] num = new int[6];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if(ward[r][c] == 1) num[1]+=map[r][c];
				else if(ward[r][c] == 2) num[2]+=map[r][c];
				else if(ward[r][c] == 3) num[3]+=map[r][c];
				else if(ward[r][c] == 4) num[4]+=map[r][c];
				else if(ward[r][c] == 5) num[5]+=map[r][c];
			}
		}
		int min = Integer.MAX_VALUE, max =0;
		for (int i = 1; i < num.length; i++) {
			min = Math.min(min, num[i]);
			max = Math.max(max, num[i]);
		}
		ans = Math.min(ans, max-min);
	}
	
	// 범위 로직
	private static boolean isIn(int x,int y, int d1, int d2) {
		return y-d1>0 && y+d2<N && y-d1+d2<N && y+d2-d1>0 
				&& x+d1<N && x+d2<N && x+d1+d2<N ;
	}
}
