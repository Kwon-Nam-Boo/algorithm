package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2115_T_벌꿀채취 {
	
	private static int N;
	private static int M;
	private static int C;
	private static int ans;
	private static int[] result;
	private static List<Integer> hList;
	private static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());				// 벌통
			M = Integer.parseInt(st.nextToken());				// 선택할 벌통 수
			C = Integer.parseInt(st.nextToken());				// 꿀 최대양
			map = new int[N][N];
			hList = new ArrayList<>();
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int k = 0;									
			int c = 0;	
			while(k<N*N) {									// 선택할 벌통의 시작점 구하기
				if((k % N) <= N-M) {
					hList.add(k);
					c++;
				}
				k++;
			}
			
			result = new int[2];
			ans = 0;
			nCr(0,0);
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void nCr(int r, int k) {				// 두 사람이 꿀 채취하는 조합의 수
		if(r == 2) {
			ans = Math.max(ans, subSet(result[0])+subSet(result[1]));
			return;
		}
		for (int i = k; i < hList.size(); i++) {
			int tmp = hList.get(i);
			if((r ==0 ||(result[r-1]+M<=tmp && (tmp/N) == (tmp+M-1)/N))){	// 서로 겹치면 안되는 조건문
				result[r] = tmp;
				nCr(r+1,i+1);
			}
		}
		
	}
	public static int subSet(int start) {				// 각 꿀통에서 채취할수 있는 최대 수익(부분집합으로)
		int big =0;										// 최대 수익
		for (int i = 1; i < (1<<M); i++) {
			boolean flag =true;
			int sum =0;
			int honey =0;
			for (int j = 0; j < M; j++) {
				if((i &(1<<j))>0){
					honey+=Math.pow(map[(start+j)/N][(start+j)%N], 2);
					sum+=map[(start+j)/N][(start+j)%N];
					if(sum >C) {						// 최대 꿀양을 넘어버리면 패스!
						flag =false;
						break;
					}
				}
			}
			if(!flag) continue;
			big = Math.max(big, honey);
		}
		return big;
	}

}
