package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_2251_물병 {

	private static StringBuilder sb = new StringBuilder();
	private static List<Integer> ans;
	private static boolean[][][] visited;
	private static int A,B,C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ans = new ArrayList<>();
		visited = new boolean[A+1][B+1][C+1];
		bfs(0, 0, C);
		Collections.sort(ans);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

	private static void bfs(int a,int b,int c) {
		
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(a,b,c));
		visited[a][b][c] = true;
		ans.add(c);
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			if(p.A == 0 && !ans.contains(p.C)) {
				ans.add(p.C);
			}
			for (int i = 0; i < 6; i++) {
				Pair tmp = pour(i , p);
				if(!visited[tmp.A][tmp.B][tmp.C]) {
					visited[tmp.A][tmp.B][tmp.C] = true;
					queue.offer(tmp);
				}
			}
		}
		
	}
	
	private static Pair pour(int i, Pair p) {
		switch(i) {
			case 0:
				if(p.A+p.B <= B)
					return new Pair(0,p.A+p.B, p.C);
				else
					return new Pair(p.A+p.B-B,B,p.C);
			case 1:
				if(p.A+p.C <= C)
					return new Pair(0,p.B, p.A+p.C);
				else
					return new Pair(p.A+p.C -C,p.B,C);
			case 2:
				if(p.B+p.A <= A)
					return new Pair(p.B+p.A,0,p.C);
				else
					return new Pair(A,p.B+p.A-A,p.C);
			case 3:
				if(p.B+p.C <= C)
					return new Pair(p.A,0,p.B+p.C);
				else
					return new Pair(p.A,p.B+p.C-C,C);	
			case 4:
				if(p.C+p.A <= A)
					return new Pair(p.C+p.A,p.B,0);
				else
					return new Pair(A,p.B,p.C+p.A - A);	
			case 5:
				if(p.C+p.B <= B)
					return new Pair(p.A,p.C+p.B,0);
				else
					return new Pair(p.A,B,p.C+p.B-B);	
		}
		return p;
	}

	public static class Pair{
		int A,B,C;

		public Pair(int a, int b, int c) {
			super();
			A = a;
			B = b;
			C = c;
		}
		
	}
	
}
