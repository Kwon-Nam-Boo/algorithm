package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_6782_D5_현주가_좋아하는_제곱근_놀이 {
	
	private static double N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			N = Double.parseDouble(br.readLine());
			int count = 0;
			while(N>2) {
				double tmp = Math.sqrt(N);
				if((long)tmp ==tmp) {
					N = tmp;
					count++;
				}else {
					// 현재 수보다 큰 제곱수 만큼 증가 시켜준다. 한번에 (그만큼 카운트)
					count += ((long)tmp +1) * ((long)tmp +1)- (long) N;
					N = ((long)tmp +1) * ((long)tmp +1);
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

}
