package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3234_D4_준환이의_양팔저울 {

	private static int N,cnt;
	private static int[] sinkers;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			sinkers = new int[N];
			visited = new boolean[N];
			st = new StringTokenizer(br.readLine());
			cnt = 0;
			for (int i = 0; i < N; i++) {
				sinkers[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(sinkers);
			NP();
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	
	public static void NP() {
		do {
			//System.out.println(Arrays.toString(sinkers));
			subSet(0, 0, 0);
		}while(nPrNP());
	}
	
	
	private static boolean nPrNP() {
		int i;
		for (i = N-2; i >= 0; i--) {
			if(sinkers[i]<sinkers[i+1]) break;
		}
		if(i<0) return false;
		
		int j;
		for (j = N-1; j >= 0; j--) {
			if(sinkers[i]<sinkers[j]) break;
		}
		swap(i,j);
		
		for (int a = i+1, b = N-1; a < b; a++ , b--) {
			swap(a,b);
		}
		return true;
	}
	
	private static void swap(int i, int j) {
		int tmp;
		tmp = sinkers[i];
		sinkers[i] = sinkers[j];
		sinkers[j] = tmp;
	}
	
	public static void subSet(int r, int right, int left) {
		if(right>left) return;
		if(r == N) {
			cnt++;
			return;
		}
		visited[r] = true;			// true: right
		
		//right+=sinkers[r];		
		subSet(r+1,right+sinkers[r],left);
		//right-=sinkers[r];	
		
		visited[r] = false;			// false: left
		
		//left+=sinkers[r];
		subSet(r+1,right,left+sinkers[r]);
		//left-=sinkers[r];
	}
	
	
	
}
