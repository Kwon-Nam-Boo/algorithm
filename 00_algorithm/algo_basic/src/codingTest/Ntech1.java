package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ntech1 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] flowers = {{2, 5}, {3, 7}, {10, 11}};
		System.out.println(solution(flowers));
	}
	
	public static int solution(int[][] flowers) {
		
		boolean[] visited = new boolean[366];
		
		for (int i = 0; i < flowers.length; i++) {
			int start = flowers[i][0];
			int end = flowers[i][1];
			for (int j = start; j < end; j++) {
				visited[j] = true;
			}
		}
		
		int answer = 0;
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]) answer++;
		}
        return answer;
    }
}
