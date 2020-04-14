package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607_P_조합 {
	
	private static int mod = 1234567891;
	private static int N;
	private static int R;
	private static long[] fac;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			fac = new long[N+1];
			factorial(N);
			
			// N! * r!^p-2 * (n-r)!^p-2 의 나머지
			long result = (fac[N]* getPow((fac[R]*fac[N-R]) % mod, mod-2)) % mod;
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	
	public static void factorial(int n) {
		fac[0] =1;
		for (int i = 1; i < fac.length; i++) {
			fac[i] = fac[i-1] * i % mod;
		}
	}
	
	// 분할 정복
	public static long getPow(long a, int n) {
		if(n == 1) return a;
		else if(n %2 == 0) {
			long re = getPow(a,n/2);
			return re*re % mod;
		}else{
			long re = getPow(a,n/2);
			return (re*re % mod)*a % mod;
		}
	}
}
