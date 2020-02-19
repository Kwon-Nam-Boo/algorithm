package algo_ad.day1;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		String src = "이름:홍길동,java:100,HTML:80,Script:85";
		
		StringTokenizer st = new StringTokenizer(src, ":,");
		System.out.println("토큰 개수:" + st.countTokens());
		st.nextToken();
		String name = st.nextToken();
		System.out.println(name);
		int sum =0;
		while(st.hasMoreTokens()){
			String cl = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			System.out.println(cl + ": " + score);
			sum+=score;
		}
		System.out.println("총점: " + sum);
	}

}
