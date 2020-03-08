package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13460_구슬탈출2 {

	private static boolean redFindHole = false;			// 빨강이 구멍에 들어갓는가? 기본값은 false;
	private static boolean blueOutHole = true;				// 파랑이 구멍에 들어가지 않았는가? 기본값은 true;
	private static int R;
	private static int C;
	private static int min;									// 탈출의 최소 횟수(답)
	private static int[] result;
	private static Pair red;								// red의 현재 위치
	private static Pair blue;								// blue의 현재 위치
	private static String[][] map;			// 원본
	private static String[][] mapClone;		// 복사본 (이동을 기록할때 사용)
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		mapClone = new String[R][C];
		for (int r = 0; r < R; r++) {
			String[] src = br.readLine().split("");
			for (int c = 0; c < C; c++) {
				map[r][c] = src[c]; 										// 원본 저장, 복사본 저장
				mapClone[r][c] = src[c];
				if(map[r][c].equals("R")) red = new Pair(r,c);				// Red,Blue의 위치 저장
				if(map[r][c].equals("B")) blue = new Pair(r,c);
			}
		}
		
		result = new int[10];												// 10번의 이동 중복순열을 담을 배열
		min = Integer.MAX_VALUE;
		nPr(0);										
		if(min ==Integer.MAX_VALUE) {										// 만약 모든경우에서 골을 통과하지 못햇다면
			System.out.println(-1);											// -1;
		}
		else System.out.println(min);
		
	}
	public static void nPr(int r){											// 10개의 이동의 중복수열을 제작한다.
		if(r == 10) {
			int re = checkResult();											// 함수: 10개의 이동을 시켜보고 확인한다.
			if(re > 0 && re < min) {										// -1(골 도착실패) 가 아니면서 최소 횟수를 저장
				min = re;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(r == 0 || result[r-1]!= i) {									// 가지치기 같은 이동이 연속으로 나오는 경우는 제외한다.
				result[r] = i;												// 위로 두번 해봣자 위로 한번 이동한거와 다를게 없으니깐
				nPr(r+1);
			}
		}
	}
	
	
	public static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}	
	}
	
	public static void move(int idx) {						// 각방향만큼 가능한 만큼 이동(벽을 만날때까지) 1.위 2.아래 2.왼 3.오
		Pair[] ared = new Pair[2];
		int tx;												//임시 x, y
		int ty;
		switch(idx) {
			case 0:		// 위
				if(red.x < blue.x) {						// Red와 Blue중 먼저 움직일것을 선택 ..		
					ared[0] = red;							// 둘중 더 위에 있는걸 먼저 움직여야 동시에 움직이는 효과가 나온다
					ared[1] = blue;
				}else {
					ared[0] = blue;
					ared[1] = red;
				}
				for (int i = 0; i < 2; i++) {
					tx = ared[i].x-1;
					ty = ared[i].y;
					while(mapClone[tx][ty].equals(".") || mapClone[tx][ty].equals("O")) {	// 해당 공이 벽에 막힐때까지 간다.
						String tmp = mapClone[tx+1][ty];									// 한칸 움직일때 마다 빈칸으로 바꾸고
						mapClone[tx+1][ty]=".";
						if(checkGoal(tx, ty, tmp)) break;									// 함수: 만약 옮기는 위치가 골이면? 끝!
						mapClone[tx][ty] =tmp;												// 아니면 해당위치에 공을 놓는다.
						ared[i].x--;
						tx = ared[i].x-1;
					}
				}
				break;
			case 1:		// 아래
				if(red.x > blue.x) {						// 방향만 다를 뿐 메커니즘은 똑같다.
					ared[0] = red;
					ared[1] = blue;
				}else {
					ared[0] = blue;
					ared[1] = red;
				}
				for (int i = 0; i < 2; i++) {
					tx = ared[i].x+1;
					ty = ared[i].y;
					while(mapClone[tx][ty].equals(".") || mapClone[tx][ty].equals("O")){
						String tmp = mapClone[tx-1][ty];
						mapClone[tx-1][ty]=".";
						if(checkGoal(tx, ty, tmp)) break;
						mapClone[tx][ty] =tmp;
						ared[i].x++;
						tx = ared[i].x+1;
					}
				}
				break;
			case 2:		// 왼쪽
				if(red.y < blue.y) {						// 방향만 다를 뿐 메커니즘은 똑같다.				
					ared[0] = red;
					ared[1] = blue;
				}else {
					ared[0] = blue;
					ared[1] = red;
				}
				for (int i = 0; i < 2; i++) {
					tx = ared[i].x;
					ty = ared[i].y-1;
					while(mapClone[tx][ty].equals(".") || mapClone[tx][ty].equals("O")) {
						String tmp = mapClone[tx][ty+1];
						mapClone[tx][ty+1]=".";
						if(checkGoal(tx, ty, tmp)) break;
						mapClone[tx][ty] =tmp;
						ared[i].y--;
						ty = ared[i].y-1;
					}
				}
				break;
			case 3:		// 오른쪽
				if(red.y > blue.y) {						// 방향만 다를 뿐 메커니즘은 똑같다.
					ared[0] = red;
					ared[1] = blue;
				}else {
					ared[0] = blue;
					ared[1] = red;
				}
				for (int i = 0; i < 2; i++) {
					tx = ared[i].x;
					ty = ared[i].y+1;
					while(mapClone[tx][ty].equals(".") || mapClone[tx][ty].equals("O")) {
						String tmp = mapClone[tx][ty-1];
						mapClone[tx][ty-1]=".";
						if(checkGoal(tx, ty, tmp)) break;
						mapClone[tx][ty] =tmp;
						ared[i].y++;
						ty = ared[i].y+1;
					}
				}
				break;
		}
	}
	
	public static boolean checkGoal(int tx, int ty, String word) {			// 골 확인 함수
		if(mapClone[tx][ty].equals("O") && word.equals("R")) {
			redFindHole = true;												// 만약 Red가 골에 들어갓다면 redFindHole true!
			return true;
		}
		else if(mapClone[tx][ty].equals("O") && word.equals("B")) {
			blueOutHole = false;											// 만약 Blue가 골에 들어갓다면 blueOutHole false!
			return true;
		}
		return false;
	}
	
	public static int checkResult() {										// 결과 확인
		int a = -1;
		for (int i = 0; i < result.length; i++) {							//10개의 move를 돌린다.
			move(result[i]);

			if(!blueOutHole) {												// 만약 blue가 goal에 들어가면
				redFindHole = false;
				blueOutHole = true;
				break;														//해당경우는 실패 (boolean은 초기화)
			}
			if(redFindHole) {												// blue는 goal에 못들어가고 red만 들어가면?
				redFindHole = false;											
				blueOutHole = true;
				a = i+1;													// 성공이므로 현재 횟수를 return;
				break;
			}
		}
		for (int r = 0; r < R; r++) {										// move를 끝내고 나서 
			for (int c = 0; c < C; c++) { 									// red, blue, mapClone을 원본으로 초기화
				mapClone[r][c] = map[r][c];
				if(map[r][c].equals("R")) red = new Pair(r,c);
				if(map[r][c].equals("B")) blue = new Pair(r,c);
			}
		}
		return a;															// 결과 return
	}
}
