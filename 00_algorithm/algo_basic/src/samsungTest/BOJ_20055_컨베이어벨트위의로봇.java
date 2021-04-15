package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20055_컨베이어벨트위의로봇 {
	
	private static int N,K;
	private static int[] belt;
	private static int[] roboat;
	private static int[] beltR;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new int[N];
		roboat = new int[N];
		beltR = new int[N];
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = N-1; i >= 0; i--) {
			beltR[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		while(true) {
			Job();
			cnt++;
			// 4. 내구도 확인
			if(checkDur()) break;
		}
		System.out.println(cnt);
	}

	private static void Job() {
		// 1. 벨트 회전
		rotate();
		// 2. 로봇 움직이기
		moveRoboat();
		// 3. 로봇올리기
		dropRoboat();
		
	}

	// 1.
	private static void rotate() {
		int tmp = belt[N-1];
		for (int i = N-1; i > 0; i--) {
			belt[i] = belt[i-1];
			roboat[i] = roboat[i-1];
		}
		belt[0] = beltR[0];
		
		roboat[0] = 0;
		roboat[N-1] = 0;
		
		for (int i = 1; i < N; i++) {
			beltR[i-1] = beltR[i];
		}
		beltR[N-1] = tmp;
	}
	
	// 2.
	private static void moveRoboat() {
		
		for (int i = N-2; i >= 0; i--) {
			// 앞에 로봇이 없고 내구도 0 이 아니라면
			if(roboat[i] == 1 && roboat[i+1] == 0 && belt[i+1] >=1) {
				roboat[i+1] = 1;
				roboat[i] = 0;
				belt[i+1]--;
			}
		}
		
	}
	// 3.
	private static void dropRoboat() {
		if(roboat[0] == 0 && belt[0] >=1) {
			roboat[0] = 1;
			belt[0]--;
		}
	}
	// 4.
	private static boolean checkDur() {
		
//		System.out.println(Arrays.toString(belt));
//		System.out.println(Arrays.toString(beltR));
//		System.out.println(Arrays.toString(roboat));
//		System.out.println();
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(belt[i] == 0) cnt++;
			if(cnt >= K) return true;
		}
		for (int i = 0; i < N; i++) {
			if(beltR[i] == 0) cnt++;
			if(cnt >= K) return true;
		}
		return false;
	}
}
