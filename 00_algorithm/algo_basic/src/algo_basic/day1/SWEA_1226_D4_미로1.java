package algo_basic.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1226_D4_미로1 {
	
	public static int result;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int n = Integer.parseInt(br.readLine());
			int[][] maze = new int[16][16];
			
			int startX=0,startY=0;
			int endX=0,endY=0;
			for (int r = 0; r < maze.length; r++) {
				String line = br.readLine();
				for (int c = 0; c < maze.length; c++) {
					maze[r][c] = Character.getNumericValue(line.charAt(c)); 
					if(maze[r][c] ==2) {				// 시작점 발견
						startX =r;
						startY =c;
					}
					if(maze[r][c] ==3) {				// 도착점 발견
						endX =r;
						endY =c;
					}
				}
			}
			result =0;
			walk(maze,startX,startY, endX,endY);		// 걷기
			sb.append(result).append("\n");				// 결과
			
		}System.out.println(sb);
		
	}
	public static void walk(int[][] maze ,int startX,int startY, int endX, int endY) {	// 걷자
		if(!isIn(maze, startX,startY) || maze[startX][startY]==1) {		// 미로 밖을 넘어서거나 1을 만나면
			return;														// 돌아간다
		}
		if(maze[startX][startY]==3) {									// 답을 만나면 채운다.
			result =1;
			return;
		}
		maze[startX][startY] = 1;				// 지나간 곳은 1로 채운다.(뒤로 못가게)
		
		walk(maze,startX-1,startY, endX,endY);	//위
		walk(maze,startX+1,startY, endX,endY);  // 아래
		walk(maze,startX,startY-1, endX,endY);  // 왼
		walk(maze,startX,startY+1, endX,endY);  //오
		
		maze[startX][startY] = 0;				// 원상복구 시킨다.
	}
	public static boolean isIn(int[][] maze, int r, int c) {
		return r>=0 && c>=0 && r<maze.length && c< maze.length;
	}

}
