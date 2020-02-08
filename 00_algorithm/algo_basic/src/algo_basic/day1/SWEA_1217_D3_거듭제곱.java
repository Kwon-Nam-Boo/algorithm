package algo_basic.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1217_D3_거듭제곱 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int c = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(power(N,M)).append("\n");
		}
		System.out.println(sb);
	}
	public static int power(int N, int M) {
		if(M == 0) return 1;
		return N*power(N, M-1);
	}

}
