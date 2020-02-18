package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9205_맥주_마시면서_걸어가기 {
	
	private static int store;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC =Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			store = Integer.parseInt(br.readLine());
		}

	}

}
