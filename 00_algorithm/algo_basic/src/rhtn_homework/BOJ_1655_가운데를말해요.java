package rhtn_homework;

import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.IOException;

public class BOJ_1655_가운데를말해요 {
	
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> right = new PriorityQueue<>();
		PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			// 두 pq의 길이가 똑같다면 right에 넣어주자(내맘)
			if(right.size() == left.size())
				right.offer(num);
			else {
				left.offer(num);
			}
			// 비어있지 않고 왼쪽이 오른쪽보다 큰경우는 swap
			if(!left.isEmpty() && !right.isEmpty() && left.peek() > right.peek()) {
				int tmp = right.poll();
				right.offer(left.poll());
				left.offer(tmp);
			}
			if(i % 2 == 0) {
				sb.append(right.peek() + "\n");
			}else {
				sb.append(Math.min(left.peek(), right.peek()) + "\n");
			}
		}
		System.out.println(sb);
		
	}

}
