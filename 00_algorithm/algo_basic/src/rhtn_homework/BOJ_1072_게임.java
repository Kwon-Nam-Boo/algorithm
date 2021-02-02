package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072_게임 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		long X = Integer.parseInt(st.nextToken());
		long Y = Integer.parseInt(st.nextToken());
		
		long Z = Y*100/X;
		
		if(Z >= 99)
			System.out.println(-1);
		else {
			long start = 0;
			long end = 1000000000;
			long mid = 0;

			while(start<=end) {
				mid = (start + end) /2;
				// 만약 Z가 변했다면
				if((Y+mid)*100/(X + mid) > Z) {
					end = mid-1;
				}else {
					start = mid+1;
				}
			}
			System.out.println(start);
		}
	}

}
