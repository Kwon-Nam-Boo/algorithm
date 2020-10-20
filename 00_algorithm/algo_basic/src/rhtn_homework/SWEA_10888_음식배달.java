package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_10888_음식배달 {

	private static StringBuilder sb = new StringBuilder();
	private static int N,ans, ans2;
	//private static int[][] map;
	private static List<Pair> house; 
	private static List<Pair> chain; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			house = new ArrayList<>();
			chain = new ArrayList<>();
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp == 1) house.add(new Pair(r,c,0));
					else if(tmp> 1) chain.add(new Pair(r,c,tmp));
				}
			}
			ans2 = Integer.MAX_VALUE;
			subset();
			sb.append("#").append(t +" ").append(ans2).append("\n");
		}
		System.out.println(sb);
	}
	private static void find(List<Pair> list) {
		ans = 0;
		boolean[] visited = new boolean[chain.size()];
		
		for (int i = 0; i < house.size(); i++) {
			Pair h = house.get(i);
			int cnt = Integer.MAX_VALUE;
			for (int j = 0; j < list.size(); j++) {
				Pair c = list.get(j);
				int tmp = Math.abs(h.r -c.r) + Math.abs(h.c -c.c);
				cnt = Math.min(cnt, Math.abs(h.r -c.r) + Math.abs(h.c -c.c));
			}
			ans+=cnt;
		}
		for (int i = 0; i < list.size(); i++) {
			ans+= list.get(i).cost;
		}
	}
	public static void subset() {
		for (int i = 1; i < 1<< chain.size(); i++) {
			List<Pair> list = new ArrayList<>();
			for (int j = 0; j < chain.size(); j++) {
				if((i & (1<<j))>0) list.add(chain.get(j));
			}
			find(list);
			ans2 = Math.min(ans2, ans);
		}
	}
	
	
	public static class Pair{
		int r,c,cost;

		@Override
		public String toString() {
			return "Pair [r=" + r + ", c=" + c + ", cost=" + cost + "]";
		}

		public Pair(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
	}
}
