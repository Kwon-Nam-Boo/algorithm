package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;
import java.util.Stack;

public class BOJ_12100_2048EASY {

	private static int N, ans;
	private static int[][] map;
	private static int[][] mapClone;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우
	private static int[] result;
	private static Stack<Integer> stack;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		mapClone = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				mapClone[r][c] = map[r][c];
			}
		}
		ans = 0;
		result = new int[5];
		nPr(0);
		System.out.println(ans);
			
	}

	private static void nPr(int i) {
		
		if(i == 5) {
			// 움직인다
			gameStart();
			return;
		}
		
		for (int j = 0; j < dir.length; j++) {
//			/if(i > 0 && result[i-1] == j) continue;
			result[i] = j;
			nPr(i+1);
		}
		
	}

	private static void gameStart() {
		
		for (int i = 0; i < result.length; i++) {
			move(result[i]);
		}
		// 초기화
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				ans = Math.max(ans, mapClone[r][c]);
				mapClone[r][c] = map[r][c];
			}
		}
		
	}

	private static void move(int d) {
		stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
	
		switch (d) {
		// 위쪽으로 갈경우
		case 0:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(mapClone[j][i] == 0) continue;
					else {
						// 이전값과 같다면
						if(!stack.isEmpty() && stack.peek() == mapClone[j][i]) {
							list.add(stack.pop()*2);
						}
						else {
							if(!stack.isEmpty()) list.add(stack.pop());
							stack.push(mapClone[j][i]);
						}
					}
				}
				while(!stack.isEmpty()) {
					list.add(stack.pop());
				}
				int size = list.size();
				int cnt= 0;
				
				for (int j = 0; j < N; j++) {
					if(cnt >= size) mapClone[j][i] = 0;
					else mapClone[j][i] = list.get(j);
					cnt++;
				}
				
				list = new ArrayList<>();
			}
			break;
		case 1:
			for (int i = 0; i < N; i++) {
				for (int j = N-1; j >= 0; j--) {
					if(mapClone[j][i] == 0) continue;
					else {
						// 이전값과 같다면
						if(!stack.isEmpty() && stack.peek() == mapClone[j][i]) {
							list.add(stack.pop()*2);
						}
						else {
							if(!stack.isEmpty()) list.add(stack.pop());
							stack.push(mapClone[j][i]);
						}
					}
				}
				while(!stack.isEmpty()) {
					list.add(stack.pop());
				}
				int size = list.size();
				int cnt = 0;
				
				for (int j = N-1; j >=0; j--) {
					if(cnt >= size) mapClone[j][i] = 0;
					else mapClone[j][i] = list.get(cnt);
					cnt++;
				}
				list = new ArrayList<>();
			}
			break;
		case 2:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(mapClone[i][j] == 0) continue;
					else {
						// 이전값과 같다면
						if(!stack.isEmpty() && stack.peek() == mapClone[i][j]) {
							list.add(stack.pop()*2);
						}
						else {
							if(!stack.isEmpty()) list.add(stack.pop());
							stack.push(mapClone[i][j]);
						}
					}
				}
				while(!stack.isEmpty()) {
					list.add(stack.pop());
				}
				
				int size = list.size();
				int cnt= 0;
				for (int j = 0; j < N; j++) {
					if(cnt >= size) mapClone[i][j] = 0;
					else mapClone[i][j] = list.get(j);
					cnt++;
				}
				list = new ArrayList<>();
			}
			break;
			
		case 3:
			for (int i = 0; i < N; i++) {
				for (int j = N-1; j >= 0; j--) {
					if(mapClone[i][j] == 0) continue;
					else {
						// 이전값과 같다면
						if(!stack.isEmpty() && stack.peek() == mapClone[i][j]) {
							list.add(stack.pop()*2);
						}
						else {
							if(!stack.isEmpty()) list.add(stack.pop());
							stack.push(mapClone[i][j]);
						}
					}
				}
				while(!stack.isEmpty()) {
					list.add(stack.pop());
				}
				int size = list.size();
				int cnt = 0;
				
				for (int j = N-1; j >=0; j--) {
					if(cnt >= size) mapClone[i][j] = 0;
					else mapClone[i][j] = list.get(cnt);
					cnt++;
				}
				list = new ArrayList<>();
			}
			break;
			
		default:
			break;
		}
		
	}

}
