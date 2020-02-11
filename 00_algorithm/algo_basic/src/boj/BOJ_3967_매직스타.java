package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_3967_매직스타 {
	
	private static int[] star;
	private static int[][] line = {
	            {0,2,5,7},
	            {1,2,3,4},
	            {1,5,8,11},
	            {0,3,6,7},
	            {7,8,9,10},
	            {4,6,9,11}
	    };
	private static int[][] = {{}}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count =0;
		star = new int[12];
		for (int i = 0; i < 5; i++) {
			String[] src = br.readLine().split("");
			for (int j = 0; j < 9; j++) {
				if(src[j].equals(".")){
					continue;
				}else if(src[j].equals("x")) {
					star[count] = 0;
					count++;
				}else {
					star[count] = src[j].charAt(0) - 64;
					count++;
				}
			}
		}
		System.out.println(Arrays.toString(star));
	}
	
	public static void bfs(int start){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		for (int i = 1; i <= 12; i++) {
			if()
		}
		
	}

}
