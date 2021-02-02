package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10989_수정렬하기3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[10000];
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			num[n]++;
		}
		
		for (int i = 0; i < num.length; i++) {
			while(num[i]>0) {
				System.out.println(i);
				num[i]--;
			}
		}
		
	}

}
