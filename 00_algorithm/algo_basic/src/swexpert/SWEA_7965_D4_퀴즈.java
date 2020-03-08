package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SWEA_7965_D4_퀴즈 {
	
	private static long[] tmp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		tmp = new long[1000001];
        for(int j = 1; j <= 1000000; j++) {					// 메모이제이션
        	tmp[j] =(tmp[j-1]+ pow(j,j)) % 1000000007;
        }
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			int N = Integer.parseInt(br.readLine());
	        sb.append(tmp[N]).append("\n");
		}
		System.out.println(sb);
	}
	
	public static long pow(int a, int b) {
        if(b == 1)
            return a;
        long po = pow(a, b/2);									// 재귀는 한번만
        if( b % 2 == 0 )
            return po * po % 1000000007;					// 변수로 사용
        else
            return po * po % 1000000007* a % 1000000007;
	}
	
}
