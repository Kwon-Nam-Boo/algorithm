package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_test {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] a = new int[2]; 
		dfs(a,0);
		a[1] =3;
		a[0] =2;
	}

	private static void dfs(int[] a, int r) {
		if(r == 2) return;
		for (int i = 0; i < 2; i++) {
			a[i] = 4;
			System.out.println(Arrays.toS);
		}
		
	}
}
