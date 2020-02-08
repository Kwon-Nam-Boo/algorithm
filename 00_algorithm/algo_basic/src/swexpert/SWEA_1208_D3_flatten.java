package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1208_D3_flatten {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int [] arr = new int[100];
			for (int j = 0; j < 100; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < N; j++) {
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				int maxI = 0, minI= 0;
				for (int j2 = 0; j2 < 100; j2++) {
					if(max < arr[j2]) {
						max = arr[j2];
						maxI = j2;
					}
					if(min > arr[j2]) {
						min = arr[j2];
						minI = j2;
					}
				}
				//System.out.println(arr[maxI] + " : " + arr[minI]);
				arr[maxI]--;
				arr[minI]++;
			}
			
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			
			for (int j = 0; j < 100; j++) {
				max = Integer.max(max,arr[j]);
				min = Integer.min(min,arr[j]);
				
			}
			sb.append(max-min).append("\n");
		}
		System.out.println(sb);
		
	}

}
