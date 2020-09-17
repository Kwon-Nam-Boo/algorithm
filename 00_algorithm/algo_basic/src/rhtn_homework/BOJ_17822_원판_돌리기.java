package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17822_원판_돌리기 {

	private static StringBuilder sb = new StringBuilder();
	private static int N,M,T;
	private static int[][] dart;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static List<Pair> rmList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		dart = new int[N][M];
		rmList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                dart[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            rotate(x, d, k);

            // 2. 근접한거 서로 지우기
            if(!remove()) {
            	// 근접한게 없다면, 평균을 구해서 ..
            	int sum =0;
            	int cnt = 0;
        		for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                    	if(dart[i][j] == 0 )continue;
                        sum+=dart[i][j];
                        cnt++;
                    }
                }
        		double avg = (double)sum / (double)cnt;
        		// 3. 평균을 기준으로 수 바꿔주기
            	change(avg);
            }

        }
		// 총합 구하기
		int ans =0;
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans+=dart[i][j];
            }
        }
		System.out.println(ans);
	}
	private static void change(double avg) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(dart[r][c] == 0 )continue;
				// 평균 보다 크면 -1, 작으면 +1 , 같으면 그대로
				if(dart[r][c] > avg) dart[r][c]--;
				else if(dart[r][c] < avg) dart[r][c]++;
			}
		}
		
	}
	private static boolean remove() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(dart[r][c] == 0 )continue;
				// 해당 속성의 4방향 탐색을 시행한다
				for (int i = 0; i < dir.length; i++) {
					int nr = dir[i][0] + r;
					int nc = dir[i][1] + c;
					
					// 단, 같은 행에 대해서는 크기 초과일 경우, 원순환 시켜야 한다
					if(nc == -1) nc = M-1;
					if(nc == M) nc = 0;
					
					// 인접한것을 발견하면 현재 수는 지워줘야하므로 삭제리스트에 저장
					// (바로바로 안지우는 이유는 해당 수를 지워버리면, 다른수가 해당수와 비교가 어렵기 때문)
					if(isIn(nr) && dart[r][c] == dart[nr][nc]) {
						rmList.add(new Pair(r,c));
						break;
					}
				}
				
			}
		}
		// 삭제 리스트가 비어있다면?, 인점 없음, change()를 수행하자
		if(rmList.isEmpty()) return false;
		
		// 삭제리스트에 존재하는 모든수를 0으로 삭제
		for (int i = 0; i < rmList.size(); i++) {
			dart[rmList.get(i).x][rmList.get(i).y] = 0;
		}
		// 비우기
		rmList.clear();
		return true;
	}
	// x: 회전시킬 원판의 배수 , d: 회전방향, k: 회전 횟수
	private static void rotate(int x, int d, int k) {
		
		for (int i = x-1; i < dart.length; i+=x) {
			// 시계 방향
			if(d == 0) {
				for (int t = 0; t < k; t++) {
					int[] tmp = dart[i].clone();
					for (int j = 0; j < tmp.length; j++) {
						dart[i][j] = tmp[(j + tmp.length-1)% tmp.length];
					}
				}
			}else {	// 반시계
				for (int t = 0; t < k; t++) {
					int[] tmp = dart[i].clone();
					for (int j = 0; j < tmp.length; j++) {
						dart[i][j] = tmp[(j + 1)% tmp.length];
					}
				}
			}
			
		}
		
	}
	public static boolean isIn(int r) {
		return r>=0&& r<N;
	}
	
	public static class Pair{
		int x, y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
