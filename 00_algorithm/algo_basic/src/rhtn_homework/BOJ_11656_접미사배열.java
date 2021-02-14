package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11656_접미사배열 {
	
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String[] arr = new String[s.length()]; 
		for (int i = arr.length -1; i >=0 ; i--) {
			arr[i] = s.substring(i, arr.length);
		}

		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb);
	}

}
