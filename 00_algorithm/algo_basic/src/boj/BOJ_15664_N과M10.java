package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ_15664_N과M10  {
	
	private static int Num;
	private static int Count;
	private static int[] result;
	private static int[] NumList;
	private static boolean[] visited;
	
	static LinkedHashSet<String> set = new LinkedHashSet<>();		// 순서대로 중복없이 저장
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Num = Integer.parseInt(st.nextToken());
		Count = Integer.parseInt(st.nextToken());
		
		result = new int[Count];
		NumList = new int[Num];
		visited = new boolean[Num];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < Num; i++) {
			NumList[i] = Integer.parseInt(st.nextToken());		// 주어진 숫자 리스트
		}
		Arrays.sort(NumList);									// 정렬
		permutation(0);
		
		Iterator<String> iter = set.iterator();			// 벡터, linkedlist, arrylist 읽어오는 인터페이스
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	public static void permutation(int d) {
		if(d == Count) {								// 깊이가 개수와 같으면 출력
			sb = new StringBuilder();
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			set.add(sb.toString());
			return;
		}else {											// 아직 깊이만큼 차지 않앗다면
			for (int i = 0; i < NumList.length; i++) {
				if(!visited[i]) {
					visited[i] =true;
				}else {
					continue;
				}
				result[d] = NumList[i];									// 현재 숫자 입력
				if(stair(d)) {
					permutation(d+1);
				}
				visited[i] =false;
			}
		}
		
	}
	public static boolean stair(int d) {
		if(d==0) {
			return true;
		}
		if(result[d-1] <= result[d]) {
			return true;
		}
		return false;
	}
	
}