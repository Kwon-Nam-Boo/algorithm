package algo_basic.day4.work;

import java.util.Scanner;

public class JA_1169_주사위던지기1 {
	
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M =sc.nextInt();
		
		switch(M) {
			case 1:
				DicePermutaion(N,0,new int[N]);
				break;
			case 2:
				DicePermutaion2(N,0, new int[N], 1); 
				break;
			case 3:
				DicePermutaion3(N,0,new int[N], new boolean[6]);
				break;
		}
		System.out.println(sb);
	}
	
	
	public static void DicePermutaion(int r, int d , int[] tmp) {
		if(d == r) {
			for (int i = 0; i < r; i++) {
				sb.append(tmp[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= 6; i++) {				
			tmp[d] = i; 
			DicePermutaion(r, d+1,tmp);
		}
		
	}
	
	public static void DicePermutaion2(int r, int d , int[] tmp, int before) {
		if(d == r) {
			for (int i = 0; i < r; i++) {
				sb.append(tmp[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = before; i <= 6; i++) {				
			tmp[d] = i; 
			DicePermutaion2(r, d+1,tmp, i);
		}
		
	}
	
	
	public static void DicePermutaion3(int r, int d , int[] tmp, boolean visited[]) {
		if(d == r) {
			for (int i = 0; i < r; i++) {
				sb.append(tmp[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < 6; i++) {
			if(!visited[i]) {
				visited[i] = true;
				tmp[d] = i+1; 
				DicePermutaion3(r, d+1,tmp,visited);
				visited[i] = false;
			}
		}
		
	}
}
