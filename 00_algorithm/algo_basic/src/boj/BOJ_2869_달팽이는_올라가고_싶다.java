package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869_달팽이는_올라가고_싶다 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double A =Integer.parseInt(st.nextToken());
		double B =Integer.parseInt(st.nextToken());
		double V =Integer.parseInt(st.nextToken());
		
		double ans = 0;
		double len = A-B;
		ans = Math.ceil(((V - A) / len)) + 1;
		System.out.println((int) ans);
	}
	
}
