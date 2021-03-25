package rhtn_homework;

import java.util.Arrays;

public class PROG_기둥과보설치_sol {
	
	static int N;
	boolean[][] Pillar;
	boolean[][] Bar;
	
	public static void main(String[] args) {
		int n = 5;
		PROG_기둥과보설치_sol prog = new PROG_기둥과보설치_sol();
		int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0}};
		int[][] sol = prog.solution(n, build_frame);
		for (int i = 0; i < sol.length; i++) {
			System.out.println(Arrays.toString(sol[i]));
		}
		
		
	}
	
	public int[][] solution(int n, int[][] build_frame) {
		
		N = n;
		Pillar = new boolean[n+1][n+1];
		Bar = new boolean[n+1][n+1];
		
		int count = 0;
		
		
		for (int[] build : build_frame) {
			int x = build[0];
        	int y = build[1];
        	int type = build[2];
        	int cmd = build[3];
        	
        	if(type == 0) {
        		// 기둥 설치
        		if(cmd ==1) {
        			if(checkPillar(x,y)) {
        				Pillar[x][y] = true;
        				count++;
        			}
        		}else {
        			Pillar[x][y] = false;
        			// 지울수 없다면
        			if(!canDelete(x,y)) {
        				Pillar[x][y] = true;
        			}else {
        				count--;
        			}
        		}
        	}else {
        		// 보 설치
        		if(cmd ==1) {
        			if(checkBar(x,y)) {
        				Bar[x][y] = true;
        				count++;
        			}
        		}else {
        			Bar[x][y] = false;
        			if(!canDelete(x,y)) {
        				Bar[x][y] = true;
        			}else {
        				count--;
        			}
        		}
        	}
		}
		
		int[][] answer = new int[count][3];
		count = 0;
		
		for (int r = 0; r <= n; r++) {
			for (int c = 0; c <= n; c++) {
				if(Pillar[r][c]) {
					answer[count][0] = r;
					answer[count][1] = c;
					answer[count++][2] = 0;
				}
				if(Bar[r][c]) {
					answer[count][0] = r;
					answer[count][1] = c;
					answer[count++][2] = 1;
				}
			}
		}
		
		return answer;
	}

	

	private boolean canDelete(int x, int y) {
		for (int i = x-1; i <=x+1; i++) {
			for (int j = y; j <=y+1; j++) {
				if(!isIn(i, j)) continue;
				if(Pillar[i][j] && !checkPillar(i, j)) return false;
				if(Bar[i][j] && !checkBar(i, j)) return false;
			}
		}
		return true;
	}

	private boolean checkPillar(int x, int y) {
		if(y == 0 || Pillar[x][y-1]) return true;
		if((isIn(x-1, y) && Bar[x-1][y]) || Bar[x][y]) return true;
		return false;
	}
	
	private boolean checkBar(int x, int y) {
		if(Pillar[x][y-1] || (isIn(x+1, y) && Pillar[x+1][y-1]))return true;
		if(isIn(x-1,y) && Bar[x-1][y] && Bar[x+1][y]) return true;
		return false;
	}
	
	private static boolean isIn(int x, int y){
		return x>=0 && y >=0 && x<=N && y<=N;
	}
}
