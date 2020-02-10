package ja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JA_1828_냉장고 {

	private static Pair[] result;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		result = new Pair[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			result[i] = new Pair(K, M);
		}
		Arrays.sort(result, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {		// 최고온도 순으로 정렬을 해야 순서대로 냉장고 확인이 가능
				Integer a = o1.h;
				Integer b = o2.h;

				return a.compareTo(b);
			}
		});
		//System.out.println(Arrays.toString(result));
		
		Pair std = result[0];
		int count= 1;
		for (int i = 1; i < N; i++) {					// 현재 냉장고를 쓰지 않는 물질이 나오면
			if(std.h <result[i].l) {					// 새로운 냉장고를 쓰고 현재 물질이 기준이 된다.
				std = result[i];
				count++;								// 냉장고 증가
			}
		}
		sb.append(count);
		System.out.println(sb);
	
	}
	public static class Pair{
		int l;
		int h;
		
		public Pair(int l, int h) {
			this.l = l;
			this.h = h;
		}

		@Override
		public String toString() {
			return "Pair [l=" + l + ", h=" + h + "]";
		}
		
	}

}
