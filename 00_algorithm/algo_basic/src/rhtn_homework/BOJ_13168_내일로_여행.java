package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_13168_내일로_여행 {

	private static StringBuilder sb = new StringBuilder();
	private static int N,R,M,K;
	private static int[][] noNaeil, Naeil; 
	private static HashMap<String, Integer> city; 
	private static String[] trav; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		city = new HashMap<>();
		for (int i = 0; i < N; i++) {
			city.put(st.nextToken(), i);
		}
		
		M = Integer.parseInt(br.readLine());
		trav = new String[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			trav[i] = st.nextToken();
		}
		
		K = Integer.parseInt(br.readLine());
		noNaeil = new int[N][N];
		Naeil = new int[N][N];
		init();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			String traf = st.nextToken();
			String start = st.nextToken();
			String end = st.nextToken();
			int cost = Integer.parseInt(st.nextToken());
			// 양방향으로 저장해둔다(물론 최소값으로)
			noNaeil[city.get(start)][city.get(end)] = Math.min(cost,noNaeil[city.get(start)][city.get(end)]);
			noNaeil[city.get(end)][city.get(start)] = noNaeil[city.get(start)][city.get(end)];
			Naeil[city.get(start)][city.get(end)] = Math.min(cost,Naeil[city.get(start)][city.get(end)]);
			Naeil[city.get(end)][city.get(start)] = Naeil[city.get(start)][city.get(end)];	
			
			// 다만 내일로 일경우 값을 좀 수정
			if(traf.equals("Mugunghwa")|| traf.equals("ITX-Saemaeul")|| traf.equals("ITX-Cheongchun")) {
				Naeil[city.get(start)][city.get(end)] = 0;
				Naeil[city.get(end)][city.get(start)] = 0;
		    }else if (traf.equals("S-Train") || traf.equals("V-Train")) {
		    	Naeil[city.get(start)][city.get(end)] = Math.min(cost/2,Naeil[city.get(start)][city.get(end)]);
		    	Naeil[city.get(end)][city.get(start)] = Naeil[city.get(start)][city.get(end)];
			}
		}
		// 플로이드 와샬
		fw();
		// 총합 구하기(내일로는 티켓값 포함)
		int sumNaeil=R, sumNo=0;
	
		for (int i = 0; i < M-1; i++) {
			sumNaeil+=Naeil[city.get(trav[i])][city.get(trav[i+1])];
			sumNo+=noNaeil[city.get(trav[i])][city.get(trav[i+1])];
		}
		// 내일로가 더 비싸면? No
		System.out.println(sumNaeil < sumNo ? "Yes": "No" );
	}
	
	// 초기화
	public static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				noNaeil[i][j] = Integer.MAX_VALUE; 
				Naeil[i][j] = Integer.MAX_VALUE; 
			}
		}
	}
	// 플로이드 와샬
	public static void fw() {
		for (int k = 0; k < N; k++) {	// 경유
			for (int i = 0; i < N; i++) {	// 출발
				if(k == i) continue;
				for (int j = 0; j < N; j++) {	// 도착
					if(k == j || i == j) continue;
					if(noNaeil[i][k]!= Integer.MAX_VALUE && noNaeil[k][j]!= Integer.MAX_VALUE 
							&& noNaeil[i][j] > noNaeil[i][k] + noNaeil[k][j])
						noNaeil[i][j] = noNaeil[i][k] + noNaeil[k][j];
					if(Naeil[i][k]!= Integer.MAX_VALUE && Naeil[k][j]!= Integer.MAX_VALUE 
							&& Naeil[i][j] > Naeil[i][k] + Naeil[k][j])
						Naeil[i][j] = Naeil[i][k] + Naeil[k][j];}
			}
		}
	}
}
