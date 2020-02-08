package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1206_D3_view {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int []arr = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int sum =0;
			for (int j = 2; j < N-2; j++) {
				int right = arr[j+1] > arr[j+2] ? arr[j+1] : arr[j+2];
				int left = arr[j-1] > arr[j-2] ? arr[j-1] : arr[j-2];
				int see = left > right ? left: right;
				sum+= ( see > arr[j] ? 0 : arr[j] - see); 
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
