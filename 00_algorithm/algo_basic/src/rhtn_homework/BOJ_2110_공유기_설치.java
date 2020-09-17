package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_공유기_설치 {

	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static long C,max,min,middle,ans;
	private static long[] house;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Long.parseLong(st.nextToken());
		house = new long[N];
		

		for (int i = 0; i < house.length; i++) {
			house[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(house);
		
		min = 1;
		max = house[N-1] - house[0];
		ans = 0;
		
		while(min<=max) {
			
			middle = (max + min) /2;
			
			if(install(middle)) {
				min = middle+1;
				ans = Math.max(middle, ans);
			}else {
				max = middle-1;
			}
		}
		System.out.println(ans);
	
		//System.out.println(install(2));
		
	}

	private static boolean install(long middle) {
		int cnt=0;
		long d=0, start= house[0];
		
		
		for (int i = 1; i < house.length; i++) {
			d = house[i] - start;
			
			if(middle<=d) {
				cnt++;
				start = house[i];
				
				//System.out.println(start);
			}
		}
		//System.out.println();
		if(cnt >= C-1) return true;
		else return false;
	}
}
