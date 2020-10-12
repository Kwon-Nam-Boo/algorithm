package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class coupang3 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = 3;
		int[] score = {24,22,20,10,5,3,2,1};
//		/int[] score = {1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100};
		System.out.println(solution(K, score));
	}
	
	private static int solution(int k, int[] score) {
		int answer = 0;
		int[] arr = new int[score.length];
		boolean[] visited = new boolean[score.length];
		for (int i = 1; i < score.length; i++) {
			arr[i]=score[i-1]-score[i];
		}
		//System.out.println(Arrays.toString(arr));
		
		int cnt =1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i < score.length; i++) {
			if(arr[i]<2) continue;
			if(!map.containsKey(arr[i])){
				map.put(arr[i], 1);
			}else {
				visited[i-1] =true;
				visited[i] = true;
				//map.put(arr[i], map.get(arr[i])+1);
			}
		}
//		Iterator<Integer> keys = map.keySet().iterator();
//		while(keys.hasNext()) {
//			int tmp = map.get(keys.next());
//			if(tmp>=2) answer+=tmp;
//		}
		for (int i = 1; i < visited.length; i++) {
			if(!visited[i]) answer++;
		}
		
		return answer;
		
	}
}
