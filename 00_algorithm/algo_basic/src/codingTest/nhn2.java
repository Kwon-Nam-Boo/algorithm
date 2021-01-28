package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class nhn2 {

	private static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int day = 2;
		int width = 6;
		int[][] blocks ={{6 ,2 ,11 ,0 ,3 ,5}, {6 ,3 ,0 ,9 ,0 ,5}};
		solution(day, width, blocks);
	}
	
	private static void solution(int day, int width, int[][] blocks) {
		
		int arr[] = new int[6];
		
		int ans = 0;
		for (int i = 0; i < blocks.length; i++) {
			int idx = 0;
			// 벽돌 쌓기
			for (int j = 0; j < arr.length; j++) {
				arr[j]+=blocks[i][j];
			}
			// 채우기
			for (int j = 1; j < blocks[i].length; j++) {
				// 만약 길이가 높은게 나타났으면 채우고 시작점 변경
				if(arr[idx] <= arr[j]) {
					for (int j2 = idx+1; j2 < j; j2++) {
						ans += (arr[idx]-arr[j2]);
						arr[j2] = arr[idx];
					}
					idx =j;
				}
			}
			// 만약 끝이 기준이 되지 못했다면 ..?
			if(idx != width-1) {
				int idx2 = width-1;
				for (int j = width-1; j >= idx; j--) {
					if(arr[idx2] <= arr[j]) {
						for (int j2 = idx2-1; j2 > idx; j2--) {
							ans += (arr[idx2]-arr[j2]);
							arr[j2] = arr[idx2];
						}
					}
					idx2 =j;
				}
			}
		}
		System.out.println(ans);
	}
}
