package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2112_T_보호_필름 {
	
	private static int D,W,K,min;
	private static int[][] film;
	private static int[] dosage; 		// 투약 정보, 방문정보
	
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <=TC; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			film = new int[D][W];
			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					film[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			dosage = new int[D];
			min = Integer.MAX_VALUE;
			subSet(0, 0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	public static void subSet(int r, int cnt) {
		if(r == D) {
			if(check()) min = Math.min(min,cnt);
			return;
		}
		if(min <= cnt) {	// 이미 앞에서 찾은 최소값보다 작을 경우 --> 굳이 다시 할 필요 없다
			return;
		}
		dosage[r] = 0;	// 투약 안 한 경우 : 0
		subSet(r+1,cnt);
		
		dosage[r] = 1;	// A 투약 : 1
		subSet(r+1,cnt+1);
		
		dosage[r] = 2;	// B 투약 : 2
		subSet(r+1,cnt+1);
	}
	private static boolean check() {
		
		for (int i = 0; i < W; i++) {
			int cnt = 1;
			for (int j = 0; j < D-1; j++) {
				int cur = film[j][i];
				int next = film[j+1][i];
				
				if(dosage[j] > 0) {		// 현재 약품 투입
					cur = dosage[j]-1;
				}
				if(dosage[j+1] > 0) {		// 현재 약품 투입
					next = dosage[j+1]-1;
				}
				if(cur == next) {
					cnt++;
					if(cnt >= K) break;		// 이미 합격기준을 맞췃다면 브레이크
				}else{
					cnt = 1;
				}
			}
			if(cnt < K) {
				return false;					// 합격 기준을 못맞추고 마지막 까지왔다면?
			}
		}
		return true;
	}
}
