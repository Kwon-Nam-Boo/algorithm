package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_2166_다각형의면적 {
	
	private static Dot[] dot; 

	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		dot = new Dot[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long x =Long.parseLong(st.nextToken());
			long y =Long.parseLong(st.nextToken());
			dot[i] = new Dot(x,y);
		}
		
		long ans = 0;
		// 주의 사항: 첫점은 기준점이 될것이므로 0을 고정하고 삼각형들을 구해줘야한다
		// 신발끈 공식을 한번 확인 할것
		for (int i = 2; i < N; i++) {
			ans+= triangle(dot[0], dot[i-1],dot[i]);
		}
		ans = Math.abs(ans);
	
		System.out.println(String.format("%.1f", Math.abs(ans)/2.0));
	}
	
	private static long triangle(Dot dot1, Dot dot2, Dot dot3) {
		long a1 = (dot1.x*dot2.y + dot2.x*dot3.y + dot3.x*dot1.y);
		long a2 = (dot1.x*dot3.y + dot3.x*dot2.y + dot2.x*dot1.y);
		return a1-a2;
	}

	public static class Dot{
		long x,y;

		public Dot(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
