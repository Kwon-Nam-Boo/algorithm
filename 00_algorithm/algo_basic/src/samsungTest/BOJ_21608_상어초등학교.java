package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_21608_상어초등학교 {

	private static int N,ss;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int[][] map;
	private static int[] student;
	private static List<Integer>[] part;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		ss= N*N;
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], -1);
		}
		
		student = new int[ss];
		part = new ArrayList[ss];
		for (int i = 0; i < ss; i++) {
			part[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < ss; i++) {
			st = new StringTokenizer(br.readLine());
			int stud = Integer.parseInt(st.nextToken())-1;
			student[i] = stud;
			part[stud].add(Integer.parseInt(st.nextToken())-1);
			part[stud].add(Integer.parseInt(st.nextToken())-1);
			part[stud].add(Integer.parseInt(st.nextToken())-1);
			part[stud].add(Integer.parseInt(st.nextToken())-1);
		}
		
		for (int i = 0; i < ss; i++) {
			findDesk(student[i]);
		}
		int ans =0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int cnt = 0;
				for (int j = 0; j < dir.length; j++) {
					int nr = dir[j][0] + r;
					int nc = dir[j][1] + c;
					if(isIn(nr,nc) && part[map[r][c]].contains(map[nr][nc])) cnt++;	
				}
				if(cnt==1) ans+=1;
				else if(cnt ==2) ans+=10;
				else if(cnt ==3) ans+=100;
				else if(cnt ==4) ans+=1000;
			}
		}
		System.out.println(ans);
		
	}
	
	private static void findDesk(int i) {
		int max = -1;
		int gr =0 , gc = 0, gn = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c]>=0) continue;
				int cnt = 0, no = 0;
				for (int j = 0; j < dir.length; j++) {
					int nr = dir[j][0] + r;
					int nc = dir[j][1] + c;
					if(isIn(nr,nc) && part[i].contains(map[nr][nc])) cnt++;
					if(isIn(nr,nc) && map[nr][nc] == -1) no++;
				}
				// 1. 조건 1
				if(cnt > max) {
					max = cnt;
					gr = r;
					gc = c;
					gn = no;
				}else if(cnt == max){
					// 조건 2
					if(gn < no) {
						max = cnt;
						gr = r;
						gc = c;
						gn = no;
					}
					else if(gn == no) {
						// 조건 3.
						if(gr == r) {
							if(gc > c) {
								max = cnt;
								gr = r;
								gc = c;
								gn = no;
							}
						}else if(gr > r) {
							max = cnt;
							gr = r;
							gc = c;
							gn = no;
						}
					}
				}
				
			}
		}
		map[gr][gc] = i;
	}

	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}

}
