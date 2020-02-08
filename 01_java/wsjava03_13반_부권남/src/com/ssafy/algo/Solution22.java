package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC= sc.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			
			sb.append("#").append(i).append(" ");
			
			int N = sc.nextInt();
			int num = sc.nextInt();
								
			boolean[][] visited = new boolean[N][N];		// 방문햇는지 안했는지의 2차원배열
			
			int[][] startPoint = new int[num][3];
			
			for (int j = 0; j < num; j++) {
				startPoint[j][0] = sc.nextInt();			// 행
				startPoint[j][1] = sc.nextInt();			// 열
				startPoint[j][2] = sc.nextInt();			// 방향
				visited[startPoint[j][0]][startPoint[j][1]] = true;
			}
			int life = num;									// 소금쟁이 수
			
			for (int j = 0; j < num; j++) {					// 1,2,3,4  상 하 좌 우
				if(startPoint[j][2] == 1) {
					life+= jumpUp(visited,startPoint ,j);	// 소금쟁이가 죽으면 -1 안죽으면 0을 더한다
				}
				if(startPoint[j][2] == 2) {
					life+=jumpDown(visited,startPoint ,j);
				}
				if(startPoint[j][2] == 3) {
					life+=jumpLeft(visited,startPoint ,j);
				}
				if(startPoint[j][2] == 4) {
					life+=jumpRight(visited,startPoint ,j);
				}
			}
			sb.append(life).append("\n");
		}
		System.out.println(sb);
	}
	
	static int jumpRight(boolean[][] visited,int[][] startPoint ,int j){		// 오른쪽으로 점프
		
		visited[startPoint[j][0]][startPoint[j][1]]= false;						// 시작점을 false;
		int tmp = startPoint[j][1];												
		
		for (int i = 3; i > 0; i--) {
			if(visited[i].length-1 < tmp+i) return -1;							// 소금쟁이가 연못밖을 벗어나면 죽는다. -1
			tmp+=i;																// 
			if(visited[startPoint[j][0]][tmp]==false) 							// false를 밟으면 pass한다	
				continue;	
			else
			return -1;															// 밟으면 죽는다 -1;
		}
		visited[startPoint[j][0]][tmp] = true;									//3 ,2 ,1 뛰고 난후 위치 true
		return 0;																// 하나도 안밟으면 0;
	}
	
	static int jumpDown(boolean[][] visited,int[][] startPoint ,int j){		
		
		visited[startPoint[j][0]][startPoint[j][1]]= false;
		int tmp = startPoint[j][0];	
		
		for (int i = 3; i > 0; i--) {
			if(visited[i].length-1 < tmp+i) return -1;;
			tmp+=i;
			if(visited[tmp][startPoint[j][1]]==false)						
				continue;
			else
			return -1;
		}
		visited[tmp][startPoint[j][1]] = true;
		return 0;
	}
	
	static int jumpUp(boolean[][] visited,int[][] startPoint ,int j){	
		
		visited[startPoint[j][0]][startPoint[j][1]]= false;
		int tmp = startPoint[j][0];	
		
		for (int i = 3; i > 0; i--) {
			if(tmp-i < 0) return -1;;
			tmp-=i;
			if(visited[tmp][startPoint[j][1]]==false)						
				continue;
			else
			return -1;
		}
		visited[tmp][startPoint[j][1]] = true;
		return 0;
	}
		
	
	static int jumpLeft(boolean[][] visited,int[][] startPoint ,int j){		
		visited[startPoint[j][0]][startPoint[j][1]]= false;
		int tmp = startPoint[j][1];										
		for (int i = 3; i > 0; i--) {
			if(tmp-i < 0) return -1;			
			tmp-=i;											
			if(visited[startPoint[j][0]][tmp]==false) 						
				continue;
			else
			return -1;										
		}
		visited[startPoint[j][0]][tmp] = true;
		return 0;											
	}
	

	

}
