package swexpert;



import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_4796_의석이의_우뚝_선_산 {
	
	private static int N;
	private static int[] mountain;

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			N = sc.nextInt();
			mountain = new int[N];
			for (int i = 0; i < N; i++) {
				mountain[i] = sc.nextInt();
			}
			
			int ans = 0;
			
			int i;
			for (i = 0; i < N; i++) {
				int start = i;
				int end = i;
				int top = i;
				
				while(i+1 < N && mountain[i]< mountain[i+1]) {
					i++;
				}
				top = i;
				while(i+1 < N && mountain[i] > mountain[i+1]) {
					i++;
				}
				end = i;
				if(start != top && top != end) {
					ans+=(top-start)*(end-top);
				}
				if(end != N-1) {
					i--;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);

	}

}
