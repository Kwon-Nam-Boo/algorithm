package algo_basic.day6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Mychu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Chu> queue = new LinkedList<>();
		
	
		for (int i = 1; i <= 20; i++) {
			if(!queue.isEmpty()) {
				
				queue.peek().chu++;
			
				Chu a = queue.poll();
				queue.add(a);
				queue.add(new Chu(i, 0));
			}else {
				queue.add(new Chu(i, 0));
				queue.peek().chu++;
				queue.add(queue.poll());
				queue.add(new Chu(i+1, 0));
			}
			
		}
		for (int i = 0; i < queue.size(); i++) {
			//System.out.println(queue.poll().num + " : ");
		}
		
	}
	static class Chu{
		
		int num;
		int chu;
		
		public Chu(int num, int chu) {
			super();
			this.num = num;
			this.chu = chu;
		}
	}
}
