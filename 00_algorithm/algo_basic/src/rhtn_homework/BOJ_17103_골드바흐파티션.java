package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17103_골드바흐파티션 {

	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> primes = new ArrayList<>();
		boolean[] check = new boolean[1000001];
		for (int i = 2; i < check.length; i++) {
			if(!check[i]) {
				primes.add(i);
				for (int j = i+i; j < check.length; j+=i) {
					check[j] = true;
				}
			}
		}
		
	
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int ans = 0;
			
			for (int x : primes){
				int y = n - x;
				if(x <= y && !check[y]){
					ans++;
				}
			}
			sb.append(ans +"\n");
		}
		System.out.println(sb);
		
	}
	
	

}
