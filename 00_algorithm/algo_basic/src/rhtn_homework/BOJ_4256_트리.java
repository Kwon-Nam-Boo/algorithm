package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4256_트리 {
	
	private static int T,N;
	private static int[] pre, in;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			pre = new int[N];
			in = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pre[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				in[i] = Integer.parseInt(st.nextToken());
			}
			post(0,N,0);
			System.out.println();
		}
		
	}

	private static void post(int start, int end,int d) {
		
		for (int i = start; i < end; i++) {
			// 만약 현재 위치의 루트랑 같은 중위순회를 찾는ㄷ면
			if(pre[d] == in[i]) {
				// 시작점부터 ~ i까지, 해당 트리의 루트 idx
				post(start, i , d+1);
				// i+1부터 ~끝점까지, 해당 트리의 루트 idx
				post(i+1, end , d+(i-start)+1);
				System.out.print(pre[d] + " ");
			}
		}
		
	}

}
