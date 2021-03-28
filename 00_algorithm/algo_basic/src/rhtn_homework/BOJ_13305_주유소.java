package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305_주유소 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[] dist = new long[N-1];
		long[] town = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < town.length; i++) {
			town[i] = Long.parseLong(st.nextToken());
		}
		
		long stand = town[0];
		long ans = 0;
		for (int i = 0; i < dist.length; i++) {
			if(stand >= town[i])
				stand = town[i];
			ans+=(dist[i]*stand);
		
		}
		System.out.println(ans);
	}
}
