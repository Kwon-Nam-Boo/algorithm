package rhtn_homework;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class pqtest {
		
	public static void main(String[] args) {
			// pq remove는 맨앞에 같은것 하나만 사라지게 된다
			PriorityQueue<String> pq = new PriorityQueue<>();
			pq.add("a");
			pq.add("b");
			pq.add("a");
			System.out.println(pq);
			pq.remove("a");
			System.out.println(pq);
			
			List<Integer> tlist = new ArrayList<>();
			tlist.add(10);
			System.out.println(tlist.contains(10));
			
	}
}