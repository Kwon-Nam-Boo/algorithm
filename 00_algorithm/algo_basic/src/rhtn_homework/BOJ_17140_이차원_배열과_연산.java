package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17140_이차원_배열과_연산 {
	
	private static int R,C,K,nr,nc;
	private static int[][] map;
	//private static List<Pair> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken())-1;
		C = Integer.parseInt(st.nextToken())-1;
		K = Integer.parseInt(st.nextToken());
		map = new int[101][101];
		
		for (int r = 0; r < 3; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c <3; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		nr = 3;
		nc = 3;
		int cnt = -1;
		for (int i = 0; i < 101; i++) {
			// 체크
			if(map[R][C] == K) {
				cnt = i;
				break;
			}
			// R연산과, C연산
			if(nr>=nc) rOperation();
			else cOperation();
		}
		
		System.out.println(cnt);
	}

	private static void cOperation() {
		int[] arr = new int[nr];
		int tmp = 0;
		
		for (int c = 0; c < nc; c++) {
			List<Pair> list = new ArrayList<>();
			for (int r = 0; r < nr; r++) {
				if(map[r][c]==0) continue;
				search(list, map[r][c]);
			}
			Collections.sort(list);
			for (int i = 0; i < nr; i++) {
				map[i][c] = 0;
			}
			for (int i = 0; i < list.size(); i++) {
				map[2*i][c]= list.get(i).i;
				map[2*i+1][c]= list.get(i).c;
			}
			tmp = Math.max(tmp, list.size()*2);
		}
		nr = tmp;
	}

	private static void rOperation() {
		int[] arr = new int[nc];
		int tmp = 0;
		for (int r = 0; r < nr; r++) {
			List<Pair> list = new ArrayList<>();
			for (int c = 0; c < nc; c++) {
				if(map[r][c]==0) continue;
				search(list, map[r][c]);
			}
			Collections.sort(list);
			map[r] = new int[101];
			for (int i = 0; i < list.size(); i++) {
				map[r][2*i]= list.get(i).i;
				map[r][2*i+1]= list.get(i).c;
			}
			tmp = Math.max(tmp, list.size()*2);
		}
		nc = tmp;
		
	}
	
	private static void search(List<Pair>list, int x) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).i == x) {
				list.get(i).c++;
				return;
			}
		}
		list.add(new Pair(x,1));
	}

	private static class Pair implements Comparable<Pair>{
		int i, c;

		@Override
		public String toString() {
			return "Pair [i=" + i + ", c=" + c + "]";
		}

		public Pair(int i, int c) {
			super();
			this.i = i;
			this.c = c;
		}

		@Override
		public int compareTo(Pair o) {
			Integer c1 = this.c;
			Integer c2 = o.c;
			Integer i1 = this.i;
			Integer i2 = o.i;
			
			//같지 않다면
			if(c1!=c2)
				return c1.compareTo(c2);
			else
				return i1.compareTo(i2);
		}
		
	}
}
