package com.robot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class WaterStrider_부권남 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res\\Solution21.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC= sc.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			
			sb.append("#").append(i).append(" ");
			
			int N = sc.nextInt();
			int num = sc.nextInt();
								
			boolean[][] visited = new boolean[N][N];		// 방문햇는지 안했는지의 2차원배열
			
			for(boolean[] bool:visited)			//false 초기화
			Arrays.fill(bool, false);			
			
			int first =0;									// 최초의 같은 장소 값
			
			for (int j = 1; j <= num; j++) {
				
				int r = sc.nextInt();						// 행
				int c = sc.nextInt();						// 열 
				int dir = sc.nextInt();						// 방향
				if(first > 0) continue;						// first값이 나오면 continue(더이상 할필요가 없기 때문에)
				
				if(visited[r][c] ==true)					// 시작점을 True로 바꾼다. 이미 true면 현재 j가 first값
					first = j;
				else
					visited[r][c] = true;
				if(first > 0) continue;
				
				if(dir ==2) {								// 오른쪽으로 뛰면
					first = jumpRight(visited,r,c,j);		// jumpRight 메소드를 사용해 first값을 찾는다. 없으면 0
					if(first > 0) continue;
				}
				
				else if(dir ==1) {							// 아래쪽으로 뛰면
					first = jumpDown(visited,r,c,j);		// jumpDown 메소드를 사용해 first값을 찾는다. 없으면 0
					if(first > 0) continue;					 
				}
				
			}
			sb.append(first).append("\n");
		}
		System.out.println(sb);
	}
	
	static int jumpRight(boolean[][] visited,int r, int c, int j){		// 오른쪽으로 3, 2, 1 뛴다
		int tmp = c;										// 현재 c의 임시 변수
		for (int i = 3; i > 0; i--) {
			if(visited[i].length-1 < tmp+i) break;			// 길이를 초과하면 break
			tmp+=i;											
			if(visited[r][tmp]==false) 						// 아직 방문한적이 없으면 true
				visited[r][tmp] = true;
			else
			return j;										// 있으면 현재 번호 j return
		}
		return 0;											// 다 방문한적 없으면 0 return
	}
	
	static int jumpDown(boolean[][] visited,int r, int c, int j){		// 아래쪽으로 3, 2, 1 뛴다
		int tmp = r;										// 현재 r의 임시 변수
		for (int i = 3; i > 0; i--) {
			if(visited[i].length-1 < tmp+i) break;
			tmp+=i;
			if(visited[tmp][c]==false)						// 형식은 jumpRight와 동일
			visited[tmp][c] = true;
			else
			return j;
		}
		return 0;
	}
	

}
