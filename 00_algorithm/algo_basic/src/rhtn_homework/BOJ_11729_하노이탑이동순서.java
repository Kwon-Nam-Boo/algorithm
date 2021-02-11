package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_11729_하노이탑이동순서 {
	
	private static int N;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		System.out.println((int)Math.pow(2, N)-1);
		Recursion(N,1,2,3);
		System.out.println(sb);
	}
	
	/*
	d : 원판의 개수
	start : 출발지
	mid : 옮기기 위해 이동해야 장소
	to : 목적지
	*/

	private static void Recursion(int d, int start, int mid , int to) {
		
		// 하나를 옮겨야 하는 상황 옮긴다
		if(d == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		
		// N-1의 재귀를 행한다. A- > B 
		Recursion(d-1, start, to, mid);
		// A -> C
		sb.append(start + " " + to + "\n");
		// N -1의 재귀를 행한다 B -> C
		Recursion(d-1, mid, start,to);
		
	}

}
