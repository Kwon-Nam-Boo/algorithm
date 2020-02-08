package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808_D3_규영이와_인영이의_카드게임 {
	
	private static int cnt; 
	private static int[] cardK; // 규영이
	private static int[] cardI; // 인영이
	private static boolean[] visited;	// 방문 기록
	private static int kW, iW;			// 규영이와 인영이의 승리수
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			st =new StringTokenizer(br.readLine());
			cardK = new int[9];
			cardI = new int[9];
			for (int j = 0; j < 9; j++) {
				//cardK.add(Integer.parseInt(st.nextToken()));
				cardK[j] =Integer.parseInt(st.nextToken());
			}
			int count =0;
			for (int j = 1; j <= 18; j++) {				// 인영이 카드 생성
				int c = 1;
				for (int k = 0; k < 9; k++) {
					if(cardK[k]== j) {
						c =0;
						break;
					}
				}
				if(c==1) {
					//cardI.add(c);
					cardI[count] = j;
					count++;
				}
			}
			
			kW=0;								// 초기화
			iW=0;
			visited = new boolean[9];
			
			dfs(new int[9], 0);					// dfs로 확인
			sb.append(kW +" ").append(iW).append("\n");
				
		}
		System.out.println(sb);
		System.out.println(cnt);
	}
	
	public static void dfs(int[] tmp , int r) {
		if(r == 9) {							// 만약 규영이의 카드가 임의의 순서로 9장이 모였다면
			int ky = 0, in=0;					// 규영이, 인영이 점수
			for (int i = 0; i < 9; i++) {
				if(tmp[i] < cardK[i]) {		// 규영이와 인영이의 i번째 비교
					ky+=(cardK[i]+tmp[i]);	// 점수 배정
				}else {
					in+=(cardK[i]+tmp[i]);
				}
			}
			if(ky > in) {						// 규영이가 인영이보다 점수 가 높으면
				kW++;		
			}else if(ky < in){					// " 낮으면 -> 비겻을 경우를 대비하여 else if 로 표현
				iW++;
			}									
		}else {
			for (int i = 0; i < 9; i++) {		// 방문한 적이 있는 지 없는지로 인영이 카드를 순열 한다
				if(!visited[i]) {
					visited[i] =true;
					tmp[r] = cardI[i];
					cnt++;
					dfs(tmp, r+1);
					visited[i] =false;
				}
			}
		}
	}
	
}
