package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SWEA_1231_D4_중위순회 {
	

	public static String result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int N = Integer.parseInt(br.readLine());
			int [][] tree = new int[N+1][2]; 
			char[] word = new char[N+1];
			for (int j = 1; j <= N; j++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				word[n] = st.nextToken().charAt(0);
				if(st.hasMoreTokens()) tree[j][0]=Integer.parseInt(st.nextToken());
				if(st.hasMoreTokens()) tree[j][1]=Integer.parseInt(st.nextToken());
			}
		
			result ="";
			inOrder(1,tree,word);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	public static void inOrder(int r ,int[][] tree, char[] word ) {
		
		if(r == 0) {
			return;
		}
		inOrder(tree[r][0],tree,word);
		
		result +=  Character.toString(word[r]);
		
		
		if(tree[r][1] == 0) {
			return;
		}
		inOrder(tree[r][1],tree,word);
		
	}
}
