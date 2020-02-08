package com.ssafy.algo;

import java.util.Scanner;

public class Solution32_13반_부권남 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int TC = sc.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			int N = sc.nextInt();					// 배열크기
			int M = sc.nextInt();
			int P = sc.nextInt();					// 사람 수
			
			int[][] jumpRoom = new int[N][M];
			
			for (int r = 0; r < N; r++) {			// 점프공간 저장
				for (int c = 0; c < M; c++) {
					jumpRoom[r][c]= sc.nextInt();
				}
			}
			
			int[][] part = new int[P][3];
			for (int r = 0; r < P; r++) {			// 참가자 정보 저장
				for (int c = 0; c < 3; c++) {
					part[r][c] = sc.nextInt();
				}
			}
			
			int trap = sc.nextInt();
			for (int j = 0; j < trap; j++) {		// 함정 설치
				int trapR = sc.nextInt()-1;
				int trapC = sc.nextInt()-1;
				jumpRoom[trapR][trapC] = 0;
			}
			
			int money = P * -1000;				//초기값은 사람수 *-1000;
			int sum = 0;
			for (int r = 0; r < P; r++) {
				int startR = part[r][0]-1;		//현재 위치의 Row
				int startC = part[r][1]-1;		//현재 위치의 Col
				int number = part[r][2];		// 점프 횟수
				int start = jumpRoom[startR][startC];	//시작점의 수치
				
				money+= jumpAll(jumpRoom, startR, startC, start,number);
			}
			sb.append(money).append("\n");
			
		}
		System.out.println(sb);

	}
	
	public static int jumpAll(int[][] jumpRoom, int r,int c, int start,int num) {
		
		for (int i = 0; i < num; i++) {
			int dir = start/10;
			int jump = start%10;
	
			switch(dir) {
			case 1:				// 오른쪽으로 점프			// 배열안에 없거나 함정이면 0원
				if(!isIn(jumpRoom,r,c+jump) || jumpRoom[r][c+jump]==0) return 0; 
				 c+=jump;
				 start=jumpRoom[r][c];
				 break;
			case 2:				// 밑으로 점프
				if(!isIn(jumpRoom,r+jump,c) || jumpRoom[r+jump][c]==0 ) return 0;
				 r+=jump;
				 start=jumpRoom[r][c];

				 break;
			case 3:				// 왼쪽으로 점프
				if(!isIn(jumpRoom,r,c-jump)|| jumpRoom[r][c-jump]==0 ) return 0;
				 c-=jump;
				 start=jumpRoom[r][c];
				 break;
			case 4:				// 위로 점프
				if(!isIn(jumpRoom,r-jump,c) || jumpRoom[r-jump][c]==0) return 0;
				 r-=jump;
				 start=jumpRoom[r][c];
				 break;
				}
		}
		return jumpRoom[r][c]*100;				// 현재위치의 수 * 100;
		
	}
	
	public static boolean isIn(int[][] data , int r, int c) {
		return r>=0 && c>=0 && r < data.length && c<data.length;
	}

}
