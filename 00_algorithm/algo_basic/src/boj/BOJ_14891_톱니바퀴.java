package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {
	
	private static List<Integer> gear1 = new LinkedList<>();
	private static List<Integer> gear2 = new LinkedList<>();
	private static List<Integer> gear3 = new LinkedList<>();
	private static List<Integer> gear4 = new LinkedList<>();
	private static List<Integer>[] gear = new LinkedList[5];
	private static int[][] arr = new int[5][2];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		gear[1] = gear1;
		gear[2] = gear2;
		gear[3] = gear3;
		gear[4] = gear4;
		
		for (int i = 1; i < 5; i++) {
			String[] src = br.readLine().split("");
			for (int j = 0; j < 8; j++) {
				gear[i].add(Integer.parseInt(src[j]));
			}
			arr[i][0] = gear[i].get(2);  
			arr[i][1] = gear[i].get(6);  
		}
		
	 	
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			spin(gear[start],dir);
			left(start-1, -dir);
			right(start+1, -dir);
			
			for (int j = 1; j < gear.length; j++) {
				arr[j][0] = gear[j].get(2);
				arr[j][1] = gear[j].get(6);
			}
			
		}
		// N = 0 S = 1;
		int score=0;
		for (int i = 1; i <5; i++) {
			if(gear[i].get(0)==1) {		// S면 점수를준다
				score +=(1<<(i-1));
			}
		}
		System.out.println(score);
		
	}
	public static void left(int i, int dir) {
		if(i == 0) {
			return;
		}	
		if(arr[i][0] != arr[i+1][1]) {
			spin(gear[i], dir);
			left(i-1,-dir);
		}else {
			return;
		}
		
	}
	public static void right(int i, int dir) {
		
		if(i==5) {
			return;
		}
		if(arr[i-1][0] != arr[i][1]) {
			spin(gear[i], dir);
			right(i+1,-dir);
		}else {
			return;
		}
		
	}
	
	public static void spin(List<Integer> gear, int dir) {
		switch(dir) {
			case -1:	// 반시계
				int first = gear.get(0);
				gear.remove(0);
				gear.add(first);
				break;
			case 1:
				int last = gear.get(7);
				gear.remove(7);
				gear.add(0,last);
				break;
		}
	}
}
