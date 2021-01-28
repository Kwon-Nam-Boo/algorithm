package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baggle01 {

	private static StringBuilder sb = new StringBuilder();
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = 4;
		int[][] ladder = {{1,0,1},{0,1,0},{0,0,1},{0,0,0},{1,0,0}};
		System.out.println(Arrays.toString(solution(n, ladder)));
	}
	
	public static int[] solution(int n, int[][] ladder) {
        int[] answer = {};
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
			arr[i]= i+1;
		}
        
        for (int i = 0; i < ladder.length; i++) {
			for (int j = 0; j < ladder[i].length; j++) {
				int tmp = ladder[i][j];
				// 만약 
				if(tmp == 1) {
					swap(j,j+1);
				}
			}
		}
        return arr;
    }

	private static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;	
	}
}
