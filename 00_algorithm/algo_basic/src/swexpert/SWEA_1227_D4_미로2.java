package swexpert;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1227_D4_미로2 {
	
	public static int result = 0;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int n = Integer.parseInt(br.readLine());
			int[][] maze = new int[100][100];
			
			int startX=0,startY=0;
			int endX=0,endY=0;
			for (int r = 0; r < maze.length; r++) {
				String line = br.readLine();
				for (int c = 0; c < maze.length; c++) {
					maze[r][c] = Character.getNumericValue(line.charAt(c)); 
					if(maze[r][c] ==2) {
						startX =r;
						startY =c;
					}
					if(maze[r][c] ==3) {
						endX =r;
						endY =c;
					}
					
				}
			}
			result =0;
			walk(maze,startX,startY, endX,endY);
			sb.append(result).append("\n");
			
		}System.out.println(sb);
		
	}
	public static void walk(int[][] maze ,int startX,int startY, int endX, int endY) {
		if(!isIn(maze, startX,startY) || maze[startX][startY]==1) {
			return;
		}
		if(maze[startX][startY]==3) {
			result =1;
			return;
		}
		maze[startX][startY] = 1;
		
		walk(maze,startX-1,startY, endX,endY);	//위
		walk(maze,startX+1,startY, endX,endY);  // 아래
		walk(maze,startX,startY-1, endX,endY);  // 왼
		walk(maze,startX,startY+1, endX,endY);  //오
		
		maze[startX][startY] = 0;
	}
	public static boolean isIn(int[][] maze, int r, int c) {
		return r>=0 && c>=0 && r<maze.length && c< maze.length;
	}

}

