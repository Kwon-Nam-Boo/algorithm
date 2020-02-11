package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정 {
	
	private static Pair[] list;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		list = new Pair[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[i] = new Pair(a,b);
		}
		Arrays.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				Integer n = o1.x;
				Integer m = o2.x;
				
				Integer a = o1.y;
				Integer b = o2.y;
				if(a==b) {
					return n.compareTo(m);
				}
				return a.compareTo(b);
			}
		});
		
		//System.out.println(Arrays.toString(list));
		Pair std = list[0];
		int count =1;
		for (int i = 1; i < list.length; i++) {
			if(std.y <= list[i].x) {
				count++;
				std = list[i];
			}
		}
		System.out.println(count);
		
	}
	
	public static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
	}

}
