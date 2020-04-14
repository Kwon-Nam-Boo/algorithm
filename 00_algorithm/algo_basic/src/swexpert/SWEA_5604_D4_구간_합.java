package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5604_D4_구간_합 {
	
	private static long A;
	private static long B;
	private static long[] ans;
	private static long point;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			A =Long.parseLong(st.nextToken());
			B =Long.parseLong(st.nextToken());
			ans = new long[10];
			point = 1;
			while(A<=B) {
				// B의 일의 자리가 9 가되도록하자
				while((B%10)<9 && A<=B) {
					cal(B);
					B--;
				}
				// A의 일의 자리가 0 가되도록하자
				if(A>B) break;
				while((A%10) > 0 && A<=B) { 
					cal(A);
					A++;
				}
				A/=10;
				B/=10;
				
				for (int i = 0; i < 10; i++) {
					ans[i]+= (B-A+1)*point;
				}
				point*=10;
			}
			long sum = 0;
			for (int i = 1; i < 10; i++) {
				sum+=(ans[i]*i);
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
	public static void cal(Long x) {
		while(x > 0) {
			String s = Long.toString(x);
			int last = s.charAt(s.length()-1) - '0';
			ans[last]+= point;
			x/=10;
		}
	}

}
