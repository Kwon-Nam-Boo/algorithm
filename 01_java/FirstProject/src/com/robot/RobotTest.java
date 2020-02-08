package com.robot;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class RobotTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res\\Solution11.txt"));
		Scanner sc =new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC = sc.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			
			sb.append("#").append(i).append(" ");
			
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			for (int r = 0; r < map.length; r++) {			// map에 데이터 저장
				for (int c = 0; c < map.length; c++) {
					map[r][c] = sc.next().charAt(0);
				}
			}
			int sum =0;
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map.length; c++) {
					if(map[r][c]== 'A') {					// A로봇은 오른쪽으로
						sum+=goRight(map,r,c);				// 이동 수를 더한다
					}
					if(map[r][c]== 'B') {					// B로봇은 양쪽으로
						sum+=goRow(map,r,c);
					}
					if(map[r][c]== 'C') {					// C로봇은 상하좌우로
						sum+=goAll(map,r,c);
					}
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
	
	static int goRight(char[][] map, int r ,int c){		// 오른쪽으로만 이동
		int count =0;
		
		for (int i = c+1; i < map.length; i++) {
			if(map[r][i]=='S') count++;
			else break;
		}
		
		return count;
	}
	static int goRow(char[][] map, int r ,int c){		// 왼쪽으로 이동  + goRight = 양쪽이동
		int count =0;

		for (int i = c-1; i >=0; i--) {
			if(map[r][i]=='S') count++;
			else break;
		}
		
		return goRight(map,r,c)+count;
	}
	static int goAll(char[][] map, int r ,int c){		// 위 아래이동 + goRow = 상하좌우 이동
		int count =0;
		
		for (int i = r+1; i < map.length; i++) {
			if(map[i][c]=='S') count++;
			else break;
		}
		for (int i = r-1; i >=0; i--) {
			if(map[i][c]=='S') count++;
			else break;
		}
		
		return goRow(map,r,c)+count;
	}
	
	
	

}
