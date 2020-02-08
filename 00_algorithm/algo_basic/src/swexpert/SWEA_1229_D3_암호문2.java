package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1229_D3_암호문2{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> al = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				al.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				
				String tp = st.nextToken();
				
				if(tp.equals("I")) {
					int start = Integer.parseInt(st.nextToken());
					int c = Integer.parseInt(st.nextToken());
					for (int k = 0; k < c; k++) {
						al.add(start+k,Integer.parseInt(st.nextToken()));
					}
				}
				if(tp.equals("D")) {
					int start = Integer.parseInt(st.nextToken());
					int c = Integer.parseInt(st.nextToken());
					for (int k = 0; k < c; k++) {
						al.remove(start);
					}
				}
				
			}
			for (int j = 0; j < 10; j++) {
				sb.append(al.get(j)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

