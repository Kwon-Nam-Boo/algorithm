package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3048_개미 {

	private static StringBuilder sb = new StringBuilder();
	private static char[] line;
	private static int[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		
		String A1 = br.readLine();
		String A2 = br.readLine();
		
		int T = Integer.parseInt(br.readLine());
		
		line = new char[A1.length() + A2.length()];
		check = new int[A1.length() + A2.length()];

		int i;
		for (i = 0; i < A1.length(); i++) {
			line[i] = A1.charAt(A1.length() - 1-i);
			check[i] = 0;
		}
		for (int j = 0; j < A2.length(); j++) {
			line[i] = A2.charAt(j);
			check[i] = 1;
			i++;
		}
		
		for (int j = 0; j < T; j++) {
			
			// 스왑할 위치를 저장해두는 배열
			int tmp[] = new int[check.length];
			// 스왑할 위치는 1
			for (int j2 = 0; j2 < check.length-1; j2++) {
				// 해당 개미가 오른쪽 , 다음개미가 왼쪽으로 가고 싶을 경우
				if(check[j2] == 0 && check[j2+1] ==1) {
					tmp[j2] = 1;
				}
			}
			// 해당 개미와 다음개미를 스왑한다
			for (int k = 0; k < tmp.length; k++) {
				if(tmp[k] == 1) {
					swap(k , k+1);
					check[k] = 1;
					check[k+1] = 0;
				}

			}
		}
		// 출력
		for (int j = 0; j < line.length; j++) {
			System.out.print(line[j]);
		}
		System.out.println();
	}
	// 스왑문
	private static void swap(int x ,int y)  {
		char tmp  = line[x];
		line[x] = line[y];
		line[y] = tmp;
	}
}
