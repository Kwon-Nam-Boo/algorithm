package rhtn_homework;

import java.util.Arrays;

public class PROG_자물쇠와열쇠 {
	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(solution(key, lock));
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
	        boolean answer = true;
	        
	        // 내부 lock의 정사각형과 key의 가동범위 사이의 거리
	        int offset = key.length-1;
	        // 가동범위를 생각한 arr 범위의 크기
	        int N = 2*offset + lock.length;
	        
	        int arr[][] = new int[N][N];
	        
	        for (int r = 0; r < lock.length + offset; r++) {
				for (int c = 0; c < lock.length + offset; c++) {
					// 4방향
					for (int d = 0; d < 4; d++) {
						arr = new int[N][N];
						// lock 만들기(사실상 초기화가 포함된 과정)
						for (int r2 = 0; r2 < lock.length; r2++) {
							for (int c2 = 0; c2 < lock.length; c2++) {
								arr[offset + r2][offset + c2] = lock[r2][c2];
							}
						}
						// 회전하고 key인지 확인하기
						rotate(arr,key,d,r,c);
						if(check(arr , offset ,lock.length)) return answer;
					}
					
				}
			}

	        return false;
	}

	private static boolean check(int[][] arr, int offset , int l) {
		
		for (int r = 0; r < l; r++) {
			for (int c = 0; c < l; c++) {
				if(arr[offset+r][offset+c]!=1) {
					return false;
				}
			}
		}
		return true;
	}

	private static void rotate(int[][] arr, int[][] key, int d, int r, int c) {
		int n = key.length-1;
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				if(d == 0) arr[i+r][j+c]+=key[i][j];
				else if(d ==1) arr[i+r][j+c]+=key[j][n-i];
				else if(d ==2) arr[i+r][j+c]+=key[n-i][n-j];
				else arr[i+r][j+c]+=key[n-j][i];
			}
		}
		
	}
}
