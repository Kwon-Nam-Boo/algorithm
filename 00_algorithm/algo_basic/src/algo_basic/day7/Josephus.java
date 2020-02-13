package algo_basic.day7;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Josephus {
		
	private static int n =24;
	private static int k =3;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byList();
		byQueue();
	
	}
	private static void byList() {
		List<Integer> solders = new LinkedList<>();
		// 초기화
		for (int i = 0; i < n; i++) {
			solders.add(i);
		}
		while(solders.size()>2) {
			solders.remove(0);
			solders.add(solders.remove(0));
			solders.add(solders.remove(0));
		}
		System.out.println(solders);
		
	}
	private static void byQueue() {
		Queue<Integer> solders = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			solders.offer(i);
		}
		
		while(solders.size() > 2) {
			solders.poll();
			solders.offer(solders.poll());
			solders.offer(solders.poll());
		}
		System.out.println(solders);
	}
}
