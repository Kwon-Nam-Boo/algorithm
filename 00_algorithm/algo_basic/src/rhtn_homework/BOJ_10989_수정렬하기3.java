package rhtn_homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10989_수정렬하기3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[10001];
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			num[n]++;
		}
		
		for (int i = 0; i < num.length; i++) {
			while(num[i]>0) {
				bw.write(i + "\n");
				num[i]--;
			}
		}
		bw.flush();
		bw.close();
		
	}

}
