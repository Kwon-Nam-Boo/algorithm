package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		int ans = 0;
		while(!pq.isEmpty()) {
			int left = pq.poll();
			if(pq.isEmpty())  break;
			int right = pq.poll();
			
			int next = left + right;
			pq.add(next);
			ans+=next;
		}
		System.out.println(ans);
	}

}
