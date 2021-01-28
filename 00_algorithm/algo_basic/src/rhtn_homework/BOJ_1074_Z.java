package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {

	private static StringBuilder sb = new StringBuilder();
	private static int N =0, R =0 ,C = 0, ans =0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		DC(0, 0 , (int) Math.round(Math.pow(2, N)));
		System.out.println(ans);
	}
	
	public static void DC(int r, int c , int l) {
		int sq = (l/2)*(l/2);
		//R , C가 2사분면인가?
		if(R < r+ l/2 && C <c + l/2)
			ans+=0;
		//R , C가 1사분면인가?
		else if(R < r+l/2 && C >=c +l/2) {
			ans+=sq;
			c+=l/2;
		}
		//R , C가 3사분면인가?
		else if(R >= r+l/2 && C < c+l/2) {
			ans+=(2*sq);
			r+=l/2;
		}
		//R , C가 4사분면인가?
		else if(R >= r+l/2 && C >= c+l/2) {
			ans+=(3*sq);
			c+=l/2;
			r+=l/2;
		}
		if(l == 2) return;
		DC(r, c , l/2);
	}	
}
