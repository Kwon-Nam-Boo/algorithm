package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927_최소힙 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				if(pq.isEmpty()) {
					System.out.println("0");
					continue;
				}
				else {
					System.out.println(pq.poll());
				}
			}else {
				pq.offer(n);
			}
		}
	}
}
