package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16235_나무제테크 {

	private static StringBuilder sb = new StringBuilder();
	private static int N,M,K,ans;
	private static int[][] map;
	private static int[][] A;
	private static int[][] dir = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	private static List<Integer>[][] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][N];
		A = new int[N][N];
		tree= new ArrayList[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				tree[r][c] = new ArrayList<>();
			}
		}
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
				map[r][c] = 5;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int a = Integer.parseInt(st.nextToken());
			tree[r][c].add(a);

		}

		for (int i = 0; i < K; i++) {
			springSummer();
			fall();
			winter();
		}
		search();
		System.out.println(ans);
	}

	private static void winter() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c]+=A[r][c];
			}
		}
	}

	private static void search() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				ans+=tree[r][c].size();
			}
		}
	}

	private static void fall() {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int i = 0; i < tree[r][c].size(); i++) {
					if(tree[r][c].get(i)%5 == 0) {
						for (int j = 0; j < 8; j++) {
							int nr = dir[j][0] + r;
							int nc = dir[j][1] + c;
							if(isIn(nr,nc)) {
								tree[nr][nc].add(1);
							}
						}
					}
				}
			}
		}
	}


	private static void springSummer(){
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int cnt = 0;
				Collections.sort(tree[r][c]);
				for (int i = 0; i < tree[r][c].size(); i++) {
					// 현재 양분 보다 작을 시
					if(tree[r][c].get(i) <= map[r][c]) {
						tree[r][c].set(i, tree[r][c].get(i)+1);
						map[r][c]-= (tree[r][c].get(i)-1);
					}
					// 현재 양분 보다 클시
					else {
						int tmp =tree[r][c].size();
						for (int j = i; j < tmp; j++) {
							cnt+=(tree[r][c].get(i)/2);
							tree[r][c].remove(i);
						}
					}
				}
				map[r][c]+=cnt;
			}
		}
		
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c< N;
	}
}
