package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952_T_수영장 {
	
	private static int[] price;
	private static int[] month;
	private static int ans;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			price = new int[4];
			month = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				price[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 13; j++) {
				month[j] = Integer.parseInt(st.nextToken());
			}
			ans = price[3];										// 1년치보다 비싸면 어차피 1년권을 사고 말지
			dfs(1,0);
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int m, int p) {
		if(m>=13) {
			ans = Math.min(ans, p);								// 현재 나온것보다 1년치 비용이 작으면 저장
			return;
		}
		if(month[m]*price[0]< price[1]) {						// 하루치의 합이 한달치보다 쌀경우  
			dfs(m+1,p+month[m]*price[0]);						// 하루치로 계산
		}else {
			dfs(m+1, p+price[1]);								// 비싸면 한달치로
		}
		dfs(m+3, p+price[2]);									// 3달치
	}

}
