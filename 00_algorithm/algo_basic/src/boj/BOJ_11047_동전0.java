package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_11047_동전0 {

	private static int N;
	private static int min = Integer.MAX_VALUE;
	private static int result;
	private static Integer[] coins;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		result = Integer.parseInt(st.nextToken());
		coins = new Integer[N];
		for (int i = 0; i < coins.length; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(coins, Collections.reverseOrder());
		
		for (int i = 0; i < coins.length; i++) {
			changeMoneyLoop(result, i);
		}
		System.out.println(min);
	}
	public static void changeMoneyLoop(int target, int from) {
		int change = 0;
		int count = 0;
		for(int i = from;i<coins.length;i++) {
			change+=coins[i];
			count++;
			if(change > target) {
				change-=coins[i];
				count--;
				continue;
			}
			if(change < target) {							
				i--;
			}else {
				min = Math.min(min, count);
				break;
			}
		}
	}

}
